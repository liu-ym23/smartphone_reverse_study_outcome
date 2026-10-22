package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntry;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams$DataSource;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams$UrlAnalysisScene;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.PhoneInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
public final class UserStatusParseUrlPreViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416638a = 0;

    public interface a {
        void a(List<String> r100);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f416639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f416640b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f416641c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Long f416642d;

        public b(String r100, String r101, String r102, Long r103) {
            Intrinsics.checkNotNullParameter(r100, "description");
            Intrinsics.checkNotNullParameter(r101, "userId");
            Intrinsics.checkNotNullParameter(r102, "sourceTextMD5");
            this.f416639a = r100;
            this.f416640b = r101;
            this.f416641c = r102;
            this.f416642d = r103;
        }
    }

    static {
    }

    public static UrlInfo a(UrlInlinePreviewEntity r100) {
        UrlInfo r101 = new UrlInfo();
        if (r100.getUdIcon() == null) goto L5;
        UDIcon r102 = r100.getUdIcon();
        RichUrlInfo r103 = new RichUrlInfo();
        d(r102, r103, r100);
        return r103;
    L5:
        String r104 = r100.getNetIconKey();
        boolean r105 = false;
        if (r104 != null) goto L8;
    L11:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L23;
        String r107 = r100.getTitle();
        if (r107 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == true) goto L23;
        KeyIconUrlInfo r109 = new KeyIconUrlInfo();
        r109.iconKey = r100.getNetIconKey();
        r109.placeHolderRes = R.drawable.ud_icon_link_copy_outlined;
        r109.text = "$" + r100.getTitle() + " ";
        r109.isUrlPreview = true;
        return r109;
    L17:
        if (r107.length() == 0) goto L20;
        r108 = false;
    L23:
        String r110 = r100.getTitle();
        if (r110 != null) goto L26;
    L27:
        r105 = true;
    L28:
        if (r105 == true) goto L30;
        RichUrlInfo r111 = new RichUrlInfo();
        r111.mLocalImageResId = R.drawable.ud_icon_link_copy_outlined;
        r111.mDisplayTitle = r100.getTitle();
        r111.text = "$" + r100.getTitle() + " ";
        return r111;
    L30:
        Log.i("[URLPreview]UserStatusParseUtils", "title is null");
        Url r112 = r100.getUrl();
        String r113 = null;
        if (r112 == null) goto L33;
        String r114 = r112.getUrl();
    L34:
        r101.content = r114;
        Url r115 = r100.getUrl();
        if (r115 == null) goto L37;
        r113 = r115.getUrl();
    L37:
        r101.text = r113;
        return r101;
    L33:
        r114 = null;
        goto L34
    L26:
        if (r110.length() != 0) goto L28;
    L8:
        if (r104.length() == 0) goto L11;
        r106 = false;
        goto L13
    }

    @JvmStatic
    public static final void b(a2b.f r100, Collection<b> r110, a r111) {
        Intrinsics.checkNotNullParameter(r100, "previewService");
        Intrinsics.checkNotNullParameter(r110, "signUrlPreviewParamsList");
        Intrinsics.checkNotNullParameter(r111, "callback");
        ArrayList r101 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L4:
        if (r112.hasNext() == false) goto L9;
        Object r102 = r112.next();
        if (StringsKt.contains$default(((b) r102).f416639a, "http", false, 2, null) == false) goto L4;
        r101.add(r102);
        goto L4
    L9:
        if (r101.isEmpty() == false) goto L11;
        return;
    L11:
        final WeakReference r113 = new WeakReference(r111);
        LinkedHashMap r114 = new LinkedHashMap();
        Iterator r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L26;
        Object r104 = r103.next();
        Long r105 = ((b) r104).f416642d;
        if (r105 == null) goto L17;
        long r106 = r105.longValue();
    L19:
        if (r106 <= 0) goto L21;
        UrlPreViewEntries.UrlPreViewSourceType r107 = UrlPreViewEntries.UrlPreViewSourceType.PRIVATE_DESCRIPTION;
    L22:
        Object r108 = r114.get(r107);
        if (r108 != null) goto L25;
        r108 = new ArrayList();
        r114.put(r107, r108);
    L25:
        ((List) r108).add(r104);
        goto L13
    L21:
        r107 = UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG;
        goto L22
    L17:
        r106 = 0;
        goto L19
    L26:
        Iterator r115 = r114.entrySet().iterator();
    L28:
        if (r115.hasNext() == false) goto L42;
        Map.Entry r109 = (Map.Entry) r115.next();
        UrlPreViewEntries.UrlPreViewSourceType r116 = (UrlPreViewEntries.UrlPreViewSourceType) r109.getKey();
        final List r117 = (List) r109.getValue();
        List r118 = r117;
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r120 = r118.iterator();
    L31:
        if (r120.hasNext() == false) goto L33;
        r119.add(((b) r120.next()).f416640b);
        goto L31
    L33:
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r122 = r118.iterator();
    L35:
        if (r122.hasNext() == false) goto L37;
        r121.add(((b) r122.next()).f416641c);
        goto L35
    L37:
        SyncDataStrategy r123 = SyncDataStrategy.TRY_LOCAL;
        ArrayList r124 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r125 = r118.iterator();
    L39:
        if (r125.hasNext() == false) goto L41;
        r124.add(((b) r125.next()).f416642d);
        goto L39
    L41:
        r100.r4(r119, r121, r123, r116, r124, new UIGetDataCallback(new UserStatusParseUrlPreViewUtils$handleBatchSignUrlRequest$1$4(r113, r117)));
        goto L28
    }

    public static void d(UDIcon r100, RichUrlInfo r101, UrlInlinePreviewEntity r102) {
        String r103 = null;
        if (r100 == null) goto L5;
        String r104 = r100.getUnicode();
    L6:
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L22;
        int r106 = edb.a.f472252a;
        if (r100 == null) goto L16;
        String r107 = r100.getKey();
    L17:
        r101.mLocalImageResId = edb.a.a(r107);
        if (r100 == null) goto L25;
        ThemeColor r108 = r100.getThemeColor();
        if (r108 == null) goto L25;
        r101.iconColor = com.ss.android.lark.export.entity.preview.a.a(r108, UIHelper.getContext(), null);
    L25:
        r101.mDisplayTitle = r102.getTitle();
        r101.text = "$" + r102.getTitle() + " ";
        return;
    L16:
        r107 = null;
        goto L17
    L22:
        if (r100 == null) goto L24;
        r103 = r100.getUnicode();
    L24:
        r101.unicode = r103;
        goto L25
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    public static Map c(List r410, Collection r411, ChatHitPointExtraParams$UrlAnalysisScene r412, ChatHitPointExtraParams$DataSource r413) {
        Intrinsics.checkNotNullParameter(r410, "data");
        Intrinsics.checkNotNullParameter(r411, "signUrlPreviewParamsList");
        HashMap r100 = new HashMap(r410.size());
        Iterator r101 = r410.iterator();
    L4:
        if (r101.hasNext() == false) goto L149;
        UrlPreViewEntries r102 = (UrlPreViewEntries) r101.next();
        String r103 = r102.getSourceId();
        boolean r104 = true;
        if (r103 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
    L13:
        Iterator r110 = r101;
    L148:
        r101 = r110;
        goto L4
    L14:
        String r106 = r102.getSourceId();
        if (r106 == null) goto L13;
        Iterator r107 = r411.iterator();
    L19:
        if (r107.hasNext() == false) goto L40;
        Object r108 = r107.next();
        b r111 = (b) r108;
        if (Intrinsics.areEqual(r111.f416640b, r106) == true) goto L23;
    L37:
        boolean r112 = false;
    L38:
        if (r112 == false) goto L19;
    L41:
        b r113 = (b) r108;
        if (r113 == null) goto L13;
        String r114 = r113.f416639a;
        if (r114.length() != 0) goto L47;
        boolean r109 = true;
    L48:
        if (r109 == true) goto L13;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r102.getEntryList().iterator();
    L51:
        if (r116.hasNext() == false) goto L143;
        UrlPreViewEntry r117 = (UrlPreViewEntry) r116.next();
        Charset r118 = Charsets.UTF_8;
        byte[] r119 = r114.getBytes(r118);
        if (r117.getPreviewEntity() == null) goto L141;
        UrlInlinePreviewEntity r120 = r117.getPreviewEntity();
        Intrinsics.checkNotNull(r120);
        if (r120.getUseColorIcon() == false) goto L85;
        UnifiedHeaderInfo r121 = r120.getHeaderInfo();
        if (r121 == null) goto L59;
        ColorIcon r122 = r121.getIcon();
    L60:
        if (r122 == null) goto L84;
        UnifiedHeaderInfo r123 = r120.getHeaderInfo();
        if (r123 == null) goto L64;
        ColorIcon r124 = r123.getIcon();
    L65:
        if (r124 != null) goto L68;
        UrlInfo r125 = null;
    L82:
        if (r125 != null) goto L86;
        r125 = new UrlInfo();
    L86:
        Url r126 = r120.getUrl();
        if (r126 == null) goto L89;
        String r127 = r126.getAndroidUrl();
    L90:
        if (r127 != null) goto L92;
    L95:
        boolean r128 = true;
    L96:
        if (r128 == false) goto L100;
        Url r129 = r120.getUrl();
        if (r129 == null) goto L103;
        String r130 = r129.getUrl();
    L104:
        r125.href = r130;
        if (r117.getOffset() > 0) goto L107;
        r125.start = 0;
    L113:
        if (r117.getOffset() < r119.length) goto L116;
        Log.i("[URLPreview]UserStatusParseUtils", "offset >= signByte.size,previewId: " + r117.getPreviewId() + ",signByte.size:" + r119.length);
        int r131 = r119.length - 1;
    L120:
        if ((r117.getOffset() + r117.getLength()) <= r119.length) goto L122;
        Log.i("[URLPreview]UserStatusParseUtils", "offset + length > signByte.size ,previewId:" + r117.getPreviewId());
        int r132 = r119.length;
    L123:
        int r133 = r125.start + new String(ArraysKt.copyOfRange(r119, r131, r132), r118).length();
        r125.end = r133;
        if (r133 <= r114.length()) goto L126;
        r125.end = r114.length();
        Log.i("[URLPreview]UserStatusParseUtils", "urlInfo.end > description.length,previewId:" + r117.getPreviewId() + ",des.length:" + r114.length());
    L126:
        String r134 = r114.substring(r125.start, r125.end);
        String r135 = r125.href;
        if (r135 != null) goto L129;
    L132:
        boolean r136 = true;
    L133:
        if (r136 == false) goto L135;
        r125.href = r134;
    L135:
        r125.type = 1;
        r115.add(r125);
        Long r137 = o1.a(r106);
        if (r137 == null) goto L142;
        if (r412 == null) goto L142;
        if (o1.a(r117.getPreviewId() + r412.getValue()) != null) goto L142;
        com.ss.android.lark.chatwindow.view.preview.i.e(r412, r117.getPreviewId(), r125.href, r413, r137.longValue());
    L142:
        r101 = r101;
        r104 = true;
        goto L51
    L129:
        if (r135.length() == 0) goto L132;
        r136 = false;
        goto L133
    L122:
        r132 = r117.getOffset() + r117.getLength();
        goto L123
    L116:
        if (r117.getOffset() <= 0) goto L118;
        r131 = r117.getOffset();
        goto L120
    L118:
        Log.i("[URLPreview]UserStatusParseUtils", "offset <= 0, previewId:" + r117.getPreviewId());
        r131 = 0;
        goto L120
    L107:
        if (r117.getOffset() <= r119.length) goto L109;
        int r138 = r119.length;
    L110:
        r125.start = new String(ArraysKt.copyOfRange(r119, 0, r138), r118).length();
        goto L113
    L109:
        r138 = r117.getOffset();
    L103:
        r130 = null;
        goto L104
    L100:
        Url r139 = r120.getUrl();
        if (r139 == null) goto L103;
        r130 = r139.getAndroidUrl();
        goto L104
    L92:
        if (r127.length() == 0) goto L95;
        r128 = false;
        goto L96
    L89:
        r127 = null;
        goto L90
    L68:
        if (r124.getUdIcon() == null) goto L71;
        RichUrlInfo r140 = new RichUrlInfo();
        d(r124.getUdIcon(), r140, r120);
        r140.isColorIcon = r104;
        UrlInfo r141 = r140;
    L70:
        r125 = r141;
        goto L82
    L71:
        KeyIconUrlInfo r142 = new KeyIconUrlInfo();
        r142.isColorIcon = r104;
        if (r124.getImageSet() == null) goto L78;
        ImageSet r143 = r124.getImageSet();
        if (r143 == null) goto L76;
        String r144 = r143.getKey();
    L77:
        r142.iconKey = r144;
    L79:
        r142.placeHolderRes = R.drawable.ud_icon_link_copy_outlined;
        r142.text = "$" + r120.getTitle() + " ";
        r142.isUrlPreview = true;
        ThemeColor r145 = r124.getThemeColor();
        r141 = r142;
        if (r145 == null) goto L70;
        r142.iconColor = com.ss.android.lark.export.entity.preview.a.a(r145, UIHelper.getContext(), null);
        r125 = r142;
        goto L82
    L76:
        r144 = null;
        goto L77
    L78:
        r142.iconKey = r124.getFaviconUrl();
        goto L79
    L64:
        r124 = null;
        goto L65
    L84:
        r101 = r101;
        r125 = a(r120);
        goto L86
    L59:
        r122 = null;
        goto L60
    L85:
        r101 = r101;
        r125 = a(r120);
        goto L86
    L141:
        r101 = r101;
        goto L142
    L143:
        r110 = r101;
        Pattern r146 = com.ss.android.lark.widget.span.g0.f448681d;
        com.ss.android.lark.widget.span.g0 r147 = com.ss.android.lark.widget.span.g0.a.f448687a;
        r147.getClass();
        if (TextUtils.isEmpty(r114) == false) goto L146;
        RecogniseSpansResult r148 = null;
    L147:
        h6b.g r149 = h6b.g.f483951b;
        UrlPreViewEntries.UrlPreViewSourceType r150 = r102.getSourceType();
        String r151 = r113.f416641c;
        Long r152 = r102.getPrivateDescriptionId();
        r149.getClass();
        h6b.g.c(r106, r150, r151, "[URLPreview] Removed Old Sign", r114, r152);
        com.ss.android.lark.widget.span.f0.a.f448675a.b(k6b.c.a(r106, r114, r102.getPrivateDescriptionId()), r148);
        h6b.g.c(r106, r102.getSourceType(), r113.f416641c, "[URLPreview] parse result Sign", r114, r102.getPrivateDescriptionId());
        r100.put(r106, r148);
        goto L148
    L146:
        ArrayList r153 = new ArrayList();
        com.ss.android.lark.widget.span.g0.a(r153, r115);
        List r154 = com.ss.android.lark.widget.span.g0.e(r114, r153);
        com.ss.android.lark.widget.span.g0.a(r153, r154);
        List r155 = com.ss.android.lark.widget.span.g0.h(r114, null, r153);
        com.ss.android.lark.widget.span.g0.a(r153, r155);
        ((ArrayList) r155).addAll(r115);
        List<PhoneInfo> r156 = r147.f(r114, r153);
        com.ss.android.lark.widget.span.g0.a(r153, r156);
        new ArrayList();
        new ArrayList();
        new ArrayList();
        r148 = new RecogniseSpansResult(r155, r154, r156, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        goto L147
    L47:
        r109 = false;
        goto L48
    L23:
        if (Intrinsics.areEqual(r111.f416641c, r102.getSourceTextMD5()) == false) goto L37;
        Long r157 = r111.f416642d;
        if (r157 == null) goto L27;
        long r158 = r157.longValue();
    L28:
        Long r159 = r102.getPrivateDescriptionId();
        if (r159 != null) goto L32;
        r159 = 0L;
    L32:
        if ((r159 instanceof Long) == false) goto L37;
        if (r158 != r159.longValue()) goto L37;
        r112 = true;
        goto L38
    L27:
        r158 = 0;
        goto L28
    L40:
        r108 = null;
        goto L41
    L8:
        if (r103.length() == 0) goto L11;
        r105 = false;
        goto L12
    L149:
        return r100;
    }
}
