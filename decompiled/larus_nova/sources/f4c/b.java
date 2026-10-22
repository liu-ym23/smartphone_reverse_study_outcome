package f4c;

import android.content.Context;
import android.view.View;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlock;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockIcon;
import com.bytedance.lark.pb.search.v2.ExtraInfoBlockSegment;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.ExtraInfoSummary;
import com.ss.android.lark.search.ui.result.SearchDependencyHolder;
import com.ss.android.lark.search.ui.result.component.ExtraInfoView;
import com.ss.android.lark.utils.t;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v3c.l;
import v3c.m;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements b08.b<ExtraInfoView, w3c.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f475598a = null;

    static {
        f475598a = new b();
    }

    public b() {
    }

    @Override // b08.b
    public final void unbind(View r100) {
        ExtraInfoView r101 = (ExtraInfoView) r100;
        Intrinsics.checkNotNullParameter(r101, "view");
        r101.setVisibility(8);
    }

    @Override // b08.b
    public final void bind(View r210, w3c.c r211) {
        ExtraInfoView r100 = (ExtraInfoView) r210;
        w3c.c r101 = r211;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (r101.f558226a.getExtraInfoList().isEmpty() == false) goto L5;
        r100.setVisibility(8);
        return;
    L5:
        r100.setVisibility(0);
        ExtraInfoSummary r102 = r101.f558226a;
        int r103 = r101.getType();
        Intrinsics.checkNotNullParameter(r102, "extraInfoSummary");
        r100.f440301e = false;
        String r104 = "";
        r100.f440298b.setText("");
        r100.f440298b.setMaxWidth(Integer.MAX_VALUE);
        r100.f440298b.setCompoundDrawablePadding(0);
        r100.f440298b.setCompoundDrawables(null, null, null, null);
        r100.f440299c.setText("");
        r100.f440300d.setText("");
        r100.f440300d.setMaxWidth(Integer.MAX_VALUE);
        r100.f440300d.setCompoundDrawablePadding(0);
        r100.f440300d.setCompoundDrawables(null, null, null, null);
        int r105 = 2;
        if (r103 != 2) goto L8;
        r105 = 1;
    L13:
        r100.f440297a = r105;
        if (r102.getExtraInfoList().isEmpty() == true) goto L118;
        ArrayList<ExtraInfoBlock> r106 = r102.getExtraInfoList();
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L18:
        if (r108.hasNext() == false) goto L78;
        ExtraInfoBlock r109 = (ExtraInfoBlock) r108.next();
        ExtraInfoBlockIcon r110 = r109.block_icon;
        if (r110 == null) goto L23;
        String r111 = r110.icon_key;
        if (r111 == null) goto L23;
    L24:
        List<ExtraInfoBlockSegment> r112 = r109.block_segments;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r114 = r112.iterator();
        int r115 = 0;
    L26:
        if (r114.hasNext() == false) goto L62;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        ExtraInfoBlockSegment r118 = (ExtraInfoBlockSegment) r116;
        if (r118 == null) goto L51;
        String r119 = r118.text_highlighted;
        if (r119 == null) goto L51;
        ExtraInfoBlockSegment.SegmentTextType r120 = r118.type;
        if (r120 == ExtraInfoBlockSegment.SegmentTextType.TIMESTAMP) goto L100;
        String r121 = r104;
        if (r120 != ExtraInfoBlockSegment.SegmentTextType.USERPROFILE) goto L49;
        ExtraInfoBlockSegment.UserProfile r122 = r118.user_profile;
        if (r122 == null) goto L48;
        r119 = r122.user_name;
        if (r119 != null) goto L49;
    L48:
        r119 = r121;
    L49:
        if (r119 != null) goto L54;
    L52:
        r119 = r121;
    L54:
        if (r115 >= (r109.block_segments.size() - 1)) goto L61;
        if (r119.length() <= 0) goto L58;
        boolean r123 = true;
    L59:
        if (r123 == false) goto L61;
        r119 = r119 + r109.segment_separator;
        goto L61
    L58:
        r123 = false;
    L61:
        r113.add(r119);
        r115 = r117;
        r104 = r121;
        goto L26
    L100:
        CastLongProtector.parseLong(r119);     // Catch: Exception -> L99
    L37:
        r121 = r104;
        long r124 = 1000;
        long r125 = System.currentTimeMillis() / r124;
        r100.f440302f.f480012a.a();
        Context r126 = r100.getContext();
        long r127 = CastLongProtector.parseLong(r119);     // Catch: Exception -> L40
    L41:
        r119 = t.a(r126, new Date(r124 * r127), ((com.ss.android.lark.search.ui.result.b) SearchDependencyHolder.f440254a.getValue()).getCachedLanguageSetting());
    L40:
        r127 = 0;
    L51:
        r121 = r104;
        goto L52
    L62:
        String r128 = r104;
        Iterator r129 = r113.iterator();
        if (r129.hasNext() == true) goto L65;
        Object r130 = null;
    L69:
        String r131 = (String) r130;
        if (r131 == null) goto L74;
        String r132 = m.a(r131);
        if (r132 == null) goto L74;
        r100.f440302f.f480012a.isEnable("lark.search.url_icon.support_more_types");
        Log.i("SearchUIFgUtils", "lark.search.url_icon.support_more_types enable is: false");
        l r133 = m.b(r132, false);
        ExtraInfoView.ExtraInfo r134 = new ExtraInfoView.ExtraInfo(r133.f552979a, new ArrayList(r133.f552980b), r111);
    L75:
        if (r134 == null) goto L77;
        r107.add(r134);
    L77:
        r104 = r128;
    L74:
        r134 = null;
        goto L75
    L65:
        r130 = r129.next();
    L67:
        if (r129.hasNext() == false) goto L69;
        r130 = ((String) r130) + ((String) r129.next());
    L23:
        r111 = r104;
        goto L24
    L78:
        String r135 = r104;
        Iterator r136 = r107.iterator();
        int r137 = 0;
    L80:
        if (r136.hasNext() == false) goto L93;
        Object r138 = r136.next();
        int r139 = r137 + 1;
        if (r137 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        ExtraInfoView.ExtraInfo r140 = (ExtraInfoView.ExtraInfo) r138;
        if (r137 != 0) goto L87;
        String r141 = r135;
        r100.b(r100.f440298b, r140.getContentWithoutTag(), r140.getTagContentList(), r140.getIconKey());
    L91:
        r137 = r139;
        r135 = r141;
        goto L80
    L87:
        if (r137 == 1) goto L89;
        r141 = r135;
        goto L91
    L89:
        r141 = r135;
        r100.b(r100.f440300d, r140.getContentWithoutTag(), r140.getTagContentList(), r141);
        goto L91
    L93:
        if (r100.f440300d.getText().length() <= 0) goto L95;
        boolean r142 = true;
    L96:
        if (r142 == false) goto L117;
        r100.f440299c.setText(r102.getExtraInfoSeparator());
        return;
    L117:
        return;
    L95:
        r142 = false;
        goto L96
    L118:
        return;
    L8:
        if (r103 == 6) goto L13;
        if (r103 == 15) goto L13;
        r105 = 0;
        goto L13
    }
}
