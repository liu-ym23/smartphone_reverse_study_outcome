package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.facebook.keyframes.model.KFAnimation;
import com.larksuite.framework.utils.FileUtils;
import com.larus.nova.R;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor;
import com.ss.android.lark.keyboard.edittext2.edittors.e;
import com.ss.android.lark.keyboard.edittext2.edittors.image.ImageEditor;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.richtext.LingoLocalExtraData;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import hob.f;
import hob.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ncc.h;

/* JADX INFO: loaded from: classes36.dex */
public class RichTextEditor extends BaseFunctionEditor<RichText> implements com.ss.android.lark.widget.richtext.b, com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f429074t = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f429076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f429077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f429078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f429079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f429080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f429081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f429082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f429083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f429084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f429085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f429086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f429087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SpannableStringBuilder f429088p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<Object> f429089q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedList<RichTextElement> f429090r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedList<Integer> f429091s;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<RichTextEditor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429092a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<RichTextEditor> a() {
            return this.f429092a.f428961a;
        }

        public a() {
            this.f429092a = new com.ss.android.lark.keyboard.edittext2.base.d(RichTextEditor.class);
        }
    }

    static {
        f429074t = new a();
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void C(RichTextElement.ItalicProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void F() {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void H(RichTextElement.ProgressSelectOptionProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void I() {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void M() {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void e(RichTextElement.SelectProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void j() {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void n() {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void v(RichTextElement.UnderlineProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void y(RichTextElement.ButtonProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final /* synthetic */ void z(RichTextElement.BoldProperty r100) {
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void E() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void O() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void h() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void l() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void w() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void x() {
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 == null) goto L6;
        W(r100);
        return;
    }

    public RichTextEditor() {
        this.f429075c = -1;
        this.f429076d = LazyKt.lazy(new RichTextEditor$styleParser$2(this));
        this.f429078f = true;
        this.f429079g = true;
        this.f429080h = true;
        this.f429081i = true;
        this.f429083k = true;
        this.f429084l = true;
        this.f429086n = -1;
        this.f429089q = new ArrayList();
        this.f429090r = new LinkedList();
        this.f429091s = new LinkedList();
    }

    public static void U(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L14;
        Character r102 = StringsKt.lastOrNull(r100);
        if (r102 != null) goto L11;
    L12:
        r100.append("\n");
        return;
    L11:
        if (r102.charValue() != '\n') goto L12;
        return;
    L14:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static void W(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.append("\n");
        return;
    L9:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void B(RichTextElement.LIProperty r100) {
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 == null) goto L5;
        W(r101);
    L5:
        if (r100 == null) goto L22;
        String r102 = r100.getListNum();
        if (r102 == null) goto L25;
        int r103 = r100.getFloor();
        int r104 = 0;
        if (r102.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L23;
        StringBuilder r106 = new StringBuilder();
    L15:
        if (r104 >= r103) goto L17;
        r106.append(tb2.c.DEFAULT_TEXT);
        r104 = r104 + 1;
        goto L15
    L17:
        r106.append(r102);
        String r107 = r106.toString();
        SpannableStringBuilder r108 = this.f429088p;
        if (r108 == null) goto L24;
        r108.append(r107);
        return;
    L24:
        return;
    L23:
        return;
    L12:
        r105 = false;
        goto L13
    L25:
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void D(RichTextElement.MyAIToolProperty r100) {
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 == null) goto L6;
        W(r101);
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void J(RichTextElement.MediaProperty r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        SpannableStringBuilder r100 = this.f429088p;
        if (r100 != null) goto L9;
        return;
    L9:
        if (this.f429080h == true) goto L12;
        r100.append(UIHelper.getString(R.string.Lark_Legacy_MessagePoVideo));
        return;
    L12:
        String r101 = r110.getOriginPath();
        String r102 = r110.getKey();
        boolean r103 = true;
        if (r102 != null) goto L15;
    L18:
        boolean r104 = true;
    L19:
        if (r104 == false) goto L21;
    L23:
        boolean r105 = false;
    L25:
        if (FileUtils.r(r101) == true) goto L29;
        if (r105 == true) goto L29;
        Log.i("RichTextEditor", "recover video failed, localPath is:" + r101);
        return;
    L29:
        int r106 = g.f486332f;
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r107 = r110.getOriginPath();
        String r108 = "";
        if (r107 != null) goto L32;
        String r109 = "";
    L33:
        String r111 = r110.getCompressPath();
        if (r111 != null) goto L36;
        String r112 = "";
    L37:
        String r113 = r110.getMime();
        if (r113 != null) goto L40;
        String r114 = "";
    L41:
        VideoInfo r115 = new VideoInfo(r109, r112, r114, r110.getSize(), r110.getDuration());
        String r116 = r110.getKey();
        if (r116 != null) goto L44;
        r116 = "";
    L44:
        r115.setKey(r116);
        r115.setOriginImage(r110.getOriginImage());
        String r117 = r110.getUrl();
        if (r117 != null) goto L47;
        r117 = "";
    L47:
        r115.setUrl(r117);
        String r118 = r110.getMediaUploadId();
        if (r118 != null) goto L50;
        r118 = "";
    L50:
        r115.setMediaUploadId(r118);
        String r119 = r110.getImageUploadId();
        if (r119 != null) goto L53;
        r119 = "";
    L53:
        r115.setImageUploadId(r119);
        int r120 = r110.getWidth();
        int r121 = r110.getHeight();
        String r122 = r110.getKey();
        if (r122 != null) goto L56;
    L59:
        boolean r123 = true;
    L60:
        if (r123 == false) goto L62;
    L64:
        r103 = false;
    L65:
        String r124 = r110.getCoverPath();
        if (r124 == null) goto L69;
        r108 = r124;
    L69:
        FrameInfo r125 = new FrameInfo(r108, r110.getWidth(), r110.getHeight());
        if (r103 == false) goto L72;
        com.ss.android.lark.widget.span.b.AbstractC5432b r126 = new com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b(r110.getOriginImage().getKey(), r110.getOriginImage().getWidth(), r110.getOriginImage().getHeight(), r110.getOriginImage().getFsUnit(), r110.getOriginImage().getCrypto());
    L73:
        g r127 = new g(r126, r110.getDuration(), r115, r125, r110);
        SpannableStringBuilder r128 = this.f429088p;
        if (r128 == null) goto L76;
        W(r128);
    L76:
        ((e) q(e.f429054e)).R(r127, r100);
        return;
    L72:
        r126 = new com.ss.android.lark.widget.span.b.AbstractC5432b.a(r110.getCoverPath(), r120, r121);
        goto L73
    L62:
        if (r110.getOriginImage() == null) goto L64;
    L56:
        if (r122.length() == 0) goto L59;
        r123 = false;
        goto L60
    L40:
        r114 = r113;
        goto L41
    L36:
        r112 = r111;
        goto L37
    L32:
        r109 = r107;
        goto L33
    L21:
        if (r110.getOriginImage() == null) goto L23;
        r105 = true;
        goto L25
    L15:
        if (r102.length() == 0) goto L18;
        r104 = false;
        goto L19
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void K(RichTextElement.CodeBlockV2Property r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f429085m == true) goto L13;
        String r102 = com.ss.android.lark.widget.codeblock.entity.a.a(r100.getLineContents());
        SpannableStringBuilder r103 = this.f429088p;
        if (r103 == null) goto L27;
        r103.append(r102);
        return;
    L27:
        return;
    L13:
        RichTextElement r104 = (RichTextElement) CollectionsKt.getOrNull(this.f429090r, 1);
        if (r104 == null) goto L16;
        RichTextElement.RichTextTag r105 = r104.getTag();
    L18:
        if (r105 == RichTextElement.RichTextTag.PARAGRAPH) goto L22;
        SpannableStringBuilder r106 = this.f429088p;
        if (r106 == null) goto L22;
        W(r106);
    L22:
        int r107 = hob.e.f486323c;
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        List<LineContent> r108 = r100.getLineContents();
        if (r108 != null) goto L25;
        r108 = CollectionsKt.emptyList();
    L25:
        hob.e r109 = new hob.e(r108, r100);
        ((com.ss.android.lark.keyboard.edittext2.edittors.c) q(com.ss.android.lark.keyboard.edittext2.edittors.c.f429047d)).R(r109, r101);
        return;
    L16:
        r105 = null;
        goto L18
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void L(RichTextElement.AtUserGroupProperty r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 != null) goto L8;
        return;
    L8:
        if (this.f429087o == false) goto L10;
    L13:
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        V(null, "@" + r100.getContentDisplayName());
        return;
    L10:
        if (r100.getPermissionStatus() != 1) goto L13;
        com.ss.android.lark.keyboard.edittext2.edittors.b r102 = (com.ss.android.lark.keyboard.edittext2.edittors.b) q(com.ss.android.lark.keyboard.edittext2.edittors.b.f429044d);
        int r103 = hob.d.f486318e;
        Intrinsics.checkNotNullParameter(r100, "atProperty");
        hob.d r104 = new hob.d(r100.getUserGroupId(), r100.getContentDisplayName(), r100.getPermissionStatus());
        r104.f486322d = false;
        r102.R(r104, r101);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void P(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "targetEditable");
        if (((ArrayList) this.f429089q).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r101 = ((ArrayList) this.f429089q).iterator();
    L7:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        int r103 = r100.getSpanStart(r102);
        int r104 = r100.getSpanEnd(r102);
        if (r103 == (-1)) goto L7;
        if (r104 == (-1)) goto L7;
        r100.setSpan(r102, r103, r104, 34);
        goto L7
    L13:
        ((ArrayList) this.f429089q).clear();
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public final void Q(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "targetEditable");
        Object[] r101 = r100.getSpans(0, r100.length(), h.class);
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L12;
        Object r105 = r101[r104];
        if (r100.getSpanFlags((h) r105) != 34) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == false) goto L10;
        r102.add(r105);
    L10:
        r104 = r104 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L12:
        if (r102.isEmpty() == false) goto L14;
        return;
    L14:
        ((ArrayList) this.f429089q).addAll(r102);
        Iterator r107 = ((ArrayList) this.f429089q).iterator();
    L16:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        int r109 = r100.getSpanStart(r108);
        int r110 = r100.getSpanEnd(r108);
        if (r109 == (-1)) goto L16;
        if (r110 == (-1)) goto L16;
        r100.setSpan(r108, r109, r110, 33);
        goto L16
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void a(RichText r100) {
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 == null) goto L5;
        int r102 = r101.length();
    L6:
        int r103 = this.f429075c;
        if (r103 < 0) goto L17;
        if (r102 < r103) goto L17;
        if (r101 == null) goto L17;
        Iterator r104 = ArrayIteratorKt.iterator((h[]) r101.getSpans(r103, r102, h.class));
    L13:
        if (r104.hasNext() == false) goto L15;
        h r105 = (h) r104.next();
        int r106 = r101.getSpanStart(r105);
        int r107 = r101.getSpanEnd(r105);
        r101.removeSpan(r105);
        r101.setSpan(r105, r106, r107, 34);
        goto L13
    L15:
        this.f429075c = -1;
        List<String> r108 = com.ss.android.lark.keyboard.edittext2.utils.b.f429249a;
        com.ss.android.lark.keyboard.edittext2.utils.b.d(r101, 0, r101.length());
        this.f429090r.clear();
        return;
    L17:
        Log.e("RichTextEditor", "replaceDraftSpanFailed, textLen:" + r102 + ", start:" + this.f429075c + ", end:" + r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void b(RichText r100) {
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f429075c = r101.length();
        Log.i("RichTextEditor", "onRenderStart:{parseTextStyle: " + this.f429077e + " , parseAt: " + this.f429078f + " , parseMedia: " + this.f429080h + " , parseImage: " + this.f429081i + " , parseAnchor: " + this.f429083k + ", parseCodeBlockV2: " + this.f429085m + "showLinkWhenParseAnchorOff : " + this.f429084l + '}');
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void f(RichTextElement.ImageProperty r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        String r100 = r110.getToken();
        boolean r101 = false;
        if (r100 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        boolean r103 = !r102;
        List<String> r104 = r110.getUrls();
        if (r104 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L22;
        if (r103 == true) goto L22;
        Log.i("RichTextEditor", "current image property has no image key or url to load");
        return;
    L22:
        SpannableStringBuilder r106 = this.f429088p;
        if (r106 != null) goto L26;
        return;
    L26:
        if (this.f429081i == true) goto L29;
        r106.append(UIHelper.getString(R.string.Lark_Legacy_ImageSummarize));
        return;
    L29:
        int r107 = f.f486326f;
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r108 = r110.getToken();
        if (r108 != null) goto L32;
    L35:
        boolean r109 = true;
    L36:
        boolean r111 = !r109;
        String r112 = r110.getToken();
        if (r111 == false) goto L53;
        String r113 = r110.getMiddleKey();
        if (r113 != null) goto L41;
    L44:
        boolean r114 = true;
    L45:
        if (r114 == false) goto L47;
        r113 = r110.getOriginKey();
    L47:
        if (r113 != null) goto L49;
    L50:
        r101 = true;
    L51:
        if (r101 == false) goto L58;
        r110.setOriginKey(r112);
        r113 = r112;
    L58:
        String r115 = r113;
    L60:
        int r116 = r110.getWidth();
        if (r110.getWidth() != 0) goto L63;
        r116 = r110.getOriginWidth();
    L63:
        int r117 = r116;
        int r118 = r110.getHeight();
        if (r110.getHeight() != 0) goto L66;
        r118 = r110.getOriginHeight();
    L66:
        int r119 = r118;
        if (r111 == false) goto L69;
        Intrinsics.checkNotNull(r115);
        com.ss.android.lark.widget.span.b.AbstractC5432b r120 = new com.ss.android.lark.widget.span.b.AbstractC5432b.C5433b(r115, r117, r119, r110.getFsUnit(), r110.getCrypto());
    L71:
        if (r112 != null) goto L73;
        r112 = "";
    L73:
        f r121 = new f(r120, r112, r110.isOriginSource(), r110);
        r121.f486331e = this.f429086n;
        SpannableStringBuilder r122 = this.f429088p;
        if (r122 == null) goto L76;
        U(r122);
    L76:
        ((ImageEditor) q(ImageEditor.f429058c)).R(r121, r106);
        return;
    L69:
        Intrinsics.checkNotNull(r115);
        r120 = new com.ss.android.lark.widget.span.b.AbstractC5432b.a(r115, r117, r119);
        goto L71
    L49:
        if (r113.length() != 0) goto L51;
    L41:
        if (r113.length() == 0) goto L44;
        r114 = false;
        goto L45
    L53:
        List<String> r123 = r110.getUrls();
        if (r123 == null) goto L59;
        r113 = (String) CollectionsKt.getOrNull(r123, 0);
        if (r113 != null) goto L58;
    L59:
        r115 = "";
        goto L60
    L32:
        if (r108.length() == 0) goto L35;
        r109 = false;
        goto L36
    L14:
        if (r104.isEmpty() == true) goto L17;
        r105 = false;
        goto L18
    L7:
        if (r100.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void i(RichTextElement.ParagraphProperty r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        SpannableStringBuilder r103 = this.f429088p;
        if (r103 != null) goto L12;
    L13:
        r101 = true;
    L14:
        if (r101 == true) goto L20;
        SpannableStringBuilder r104 = this.f429088p;
        if (r104 == null) goto L21;
        W(r104);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        if (r103.length() != 0) goto L14;
    L19:
        return;
    L5:
        if (r100.getIsNeedEnter() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void o(RichTextElement.MarkdownProperty r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = r100.getContent();
        if (r101 != null) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return;
    L13:
        SpannableStringBuilder r103 = this.f429088p;
        if (r103 != null) goto L16;
        return;
    L16:
        int r104 = r103.length();
        V(null, r101);
        int r105 = r103.length();
        if (r105 > r104) goto L19;
        return;
    L19:
        RichTextElement r106 = new RichTextElement();
        r106.setTag(RichTextElement.RichTextTag.MARKDOWN);
        RichTextElement.MarkdownProperty r107 = new RichTextElement.MarkdownProperty();
        r107.setContent(r100.getContent());
        r107.setImages(r100.getImages());
        r107.setAtUserIds(r100.getAtUserIds());
        r107.setAtAll(r100.isAtAll());
        r107.setAtUsers(r100.getAtUsers());
        r106.setProperty(r107);
        r103.setSpan(new p(r106, r101), r104, r105, 18);
        return;
    L7:
        if (r101.length() == 0) goto L10;
        r102 = false;
        goto L11
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void p(RichTextElement r100) {
        this.f429090r.push(r100);
        LinkedList<Integer> r101 = this.f429091s;
        SpannableStringBuilder r102 = this.f429088p;
        if (r102 == null) goto L5;
        int r103 = r102.length();
    L6:
        r101.push(Integer.valueOf(r103));
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void r(RichTextElement.EmotionProperty r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r101 = this.f429088p;
        if (r101 != null) goto L7;
        return;
    L7:
        ((com.ss.android.lark.keyboard.edittext2.edittors.d) q(com.ss.android.lark.keyboard.edittext2.edittors.d.f429050e)).R(r100.getKey(), r101);
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public void s(RichTextElement r100) {
        if (this.f429090r.isEmpty() == true) goto L6;
        this.f429090r.pop();
    L6:
        if (this.f429091s.isEmpty() == true) goto L9;
        this.f429091s.pop();
        return;
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void u(RichTextElement.MentionProperty r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        V(null, r100.getContent());
    }

    @Override // com.ss.android.lark.widget.richtext.b
    public final void N(RichTextElement.TextProperty r100, Map<String, String> r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getContent();
    L5:
        V(r101, r102);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public final void V(Map<String, String> r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L18;
        SpannableStringBuilder r103 = this.f429088p;
        if (r103 == null) goto L19;
        Intrinsics.checkNotNullParameter(r101, "content");
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        r104.append(r101);
        if (this.f429077e == false) goto L16;
        lec.f r105 = (lec.f) this.f429076d.getValue();
        r105.d();
        r105.c(r100);
        TextStyleInfo r106 = r105.e(r101);
        c.a(r104, 0, r101.length(), r106);
    L16:
        r103.append(r104);
        return;
    L19:
        return;
    L18:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public void X(SpannableStringBuilder r100, RichText r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f429088p = r100;
        com.ss.android.lark.widget.richtext.g.b(r101, this);
        SpannableStringBuilder r102 = this.f429088p;
        if (r102 == null) goto L21;
        if (r101 == null) goto L18;
        RichTextExtraInfo r103 = r101.getExtraInfo();
        if (r103 == null) goto L19;
        LingoLocalExtraData r104 = r103.getLingoLocalExtraData();
        if (r104 == null) goto L22;
        com.ss.android.lark.keyboard.edittext2.span.g[] r105 = (com.ss.android.lark.keyboard.edittext2.span.g[]) r102.getSpans(0, r102.length(), com.ss.android.lark.keyboard.edittext2.span.g.class);
        Intrinsics.checkNotNull(r105);
        if (r105.length != 0) goto L14;
        boolean r106 = true;
    L15:
        if (r106 == false) goto L20;
        com.ss.android.lark.keyboard.edittext2.span.g r107 = new com.ss.android.lark.keyboard.edittext2.span.g();
        r107.f429217b = r104.getPinInfo();
        r107.f429216a = r104.getHighlightIgnoreWords();
        r102.setSpan(r107, 0, r102.length(), 18);
        return;
    L20:
        return;
    L14:
        r106 = false;
        goto L15
    L22:
        return;
    L19:
        return;
    L18:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.widget.richtext.b
    public final void m(RichTextElement.AnchorProperty r100, Map<String, String> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r102 = this.f429088p;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f429083k == false) goto L10;
        eob.a r103 = (eob.a) q(eob.a.f473406f);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "anchorProperty");
        Iterator<T> r104 = r103.f473409e.values().iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        fob.c r105 = (fob.c) r104.next();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.ss.android.lark.keyboard.edittext2.edittors.anchor.base.IAnchorResolver<com.ss.android.lark.widget.richtext.RichTextElement.AnchorProperty, out com.ss.android.lark.keyboard.edittext2.edittors.editinfo.InsertAnchorInfo>");
        fob.c.a r106 = r105.resolve(r100);
        if (r106.f478191a == false) goto L16;
        hob.b r107 = (hob.b) r106.f478192b;
    L21:
        if (r107 != null) goto L24;
        Log.i("RichTextEditor", "insertAnchorElement: insertInfo is null , method return");
        V(r101, r100.getHref());
        return;
    L24:
        if (this.f429077e == false) goto L26;
        r107.f486305b = r101;
    L26:
        r103.R(r107, r102);
        return;
    L20:
        Log.w("AnchorEditor", "parseAnchorProperty: found no anchor strategy to handle anchorProperty");
        r107 = null;
        goto L21
    L10:
        if (this.f429084l == false) goto L12;
        String r108 = r100.getHref();
    L13:
        V(r101, r108);
        return;
    L12:
        r108 = r100.getContent();
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.widget.richtext.b
    public void t(RichTextElement.AtProperty r100, Map<String, String> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        SpannableStringBuilder r102 = this.f429088p;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f429078f == true) goto L11;
        V(r101, r100.getAtContent());
        return;
    L11:
        com.ss.android.lark.keyboard.edittext2.edittors.a r103 = (com.ss.android.lark.keyboard.edittext2.edittors.a) q(com.ss.android.lark.keyboard.edittext2.edittors.a.f428974e);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "atProperty");
        boolean r104 = true;
        if (r100.getUserId().length() != 0) goto L14;
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
    L32:
        Log.i("ATEditor", "tryParseAtProperty: chatter id or chatter name is null. now return");
    L33:
        hob.c r106 = null;
    L34:
        if (r106 != null) goto L36;
        Log.i("RichTextEditor", "insertAtElement: insertInfo is null, method return");
        V(r101, r100.getAtContent());
        return;
    L36:
        r106.f486313f = false;
        if (this.f429077e == false) goto L39;
        r106.f486315h = r101;
    L39:
        r103.R(r106, r102);
        return;
    L18:
        if (r100.getAtContent().length() == 0) goto L21;
        r104 = false;
    L21:
        if (r104 == true) goto L32;
        if (r100.isAnonymous() == true) goto L32;
        Iterator r107 = ((LinkedHashMap) r103.f428975c).entrySet().iterator();
    L27:
        if (r107.hasNext() == false) goto L31;
        fob.c.a r108 = ((com.ss.android.lark.keyboard.edittext2.edittors.at.c) ((Map.Entry) r107.next()).getValue()).k(r103, r100);
        if (r108.f478191a == false) goto L27;
        r106 = (hob.c) r108.f478192b;
        goto L34
    L31:
        Log.w("ATEditor", "parseAtProperty: found no at strategy to handle atProperty");
        goto L33
    L14:
        r105 = false;
        goto L16
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.BaseFunctionEditor
    public /* bridge */ /* synthetic */ void S(SpannableStringBuilder r100, RichText r101, int r102) {
        X(r100, r101);
    }
}
