package com.ss.android.lark.widget.richtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ComposeImageView;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.media.RichTextVideoView;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import com.ss.android.lark.widget.span.AtInfo;
import com.ss.android.lark.widget.span.ChatInfo;
import com.ss.android.lark.widget.span.EmojiconInfo;
import com.ss.android.lark.widget.span.ImageInfo;
import com.ss.android.lark.widget.span.KeyIconUrlInfo;
import com.ss.android.lark.widget.span.MentionInfo;
import com.ss.android.lark.widget.span.PhoneInfo;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.RichUrlInfo;
import com.ss.android.lark.widget.span.SpacingInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import com.ss.android.lark.widget.span.TextStyleInfo;
import com.ss.android.lark.widget.span.UrlInfo;
import com.ss.android.lark.widget.span.g0;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public class RichTextView extends LinearLayout {

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static Boolean f448210x1;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public boolean F;
    public float G;
    public float H;
    public boolean H0;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f448211J;
    public int K;
    public int L;
    public String L0;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean P0;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public int V;
    public boolean V0;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f448212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f448213b;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f448214b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkEmojiTextView.i f448215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public mcc.o f448216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkEmojiTextView.f f448217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public mcc.i f448218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mcc.j f448219g;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f448220g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinkEmojiTextView.h f448221h;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f448222h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinkEmojiTextView.e f448223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public mcc.c f448224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f448225k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public float f448226k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f448227k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public StringBuilder f448228l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RichText f448229m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f448230n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f448231o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f448232p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f448233p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final a f448234p1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f448235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f448236r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f448237s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<String> f448238t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<String> f448239u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f448240v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f448241v1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f448242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f448243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f448244y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f448245z;

    public class a implements com.ss.android.lark.widget.richtext.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<UrlInfo> f448246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<AtInfo> f448247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<MentionInfo> f448248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<PhoneInfo> f448249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<ChatInfo> f448250e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<TextStyleInfo> f448251f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<AbbreviationInfo> f448252g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<ImageInfo> f448253h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<SpacingInfo> f448254i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List<EmojiconInfo> f448255j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ RichTextView f448256k;

        @Override // com.ss.android.lark.widget.richtext.b
        public final void B(RichTextElement.LIProperty r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void E() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void F() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void H(RichTextElement.ProgressSelectOptionProperty r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final /* synthetic */ void I() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final /* synthetic */ void L(RichTextElement.AtUserGroupProperty r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void M() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void O() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void b(RichText r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void e(RichTextElement.SelectProperty r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void h() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void j() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void l() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final /* synthetic */ void o(RichTextElement.MarkdownProperty r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final /* synthetic */ void p(RichTextElement r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final /* synthetic */ void s(RichTextElement r100) {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void w() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void x() {
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void y(RichTextElement.ButtonProperty r100) {
        }

        public final void d() {
            RichTextView r100 = this.f448256k;
            if (r100.f448228l != null) goto L6;
            return;
        L6:
            if (r100.C == false) goto L8;
            int r101 = r100.getChildCount();
            RichTextView r102 = this.f448256k;
            int r103 = r102.f448230n;
            if (r103 < r101) goto L29;
            Log.e("RichTextView", "Failed to refresh textview, it's not same richtext");
        L42:
            RichTextView r104 = this.f448256k;
            r104.f448230n++;
            r104.f448228l = null;
            this.f448247b = new ArrayList();
            this.f448248c = new ArrayList();
            this.f448246a = new ArrayList();
            this.f448251f = new ArrayList();
            this.f448252g = new ArrayList();
            this.f448253h = new ArrayList();
            this.f448254i = new ArrayList();
            this.f448255j = new ArrayList();
            return;
        L29:
            if ((r102.getChildAt(r103) instanceof LinkEmojiTextView) == true) goto L32;
            Log.e("RichTextView", "Failed to get LinkEmojiTextView, it's not same richtext");
            goto L42
        L32:
            if (CollectionUtils.isEmpty(this.f448247b) == true) goto L34;
        L37:
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            ArrayList r105 = new ArrayList();
            new ArrayList();
            RecogniseSpansResult r106 = new RecogniseSpansResult(this.f448246a, this.f448247b, this.f448249d, this.f448250e, this.f448251f, this.f448252g, this.f448253h, this.f448254i, this.f448248c, r105, this.f448255j, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        L38:
            RichTextView r107 = this.f448256k;
            if (r107.D == false) goto L41;
            LinkEmojiTextView r108 = RichTextView.b(r107, r107.f448228l.toString(), r106);
            this.f448256k.c(r108);
            RichTextView r109 = this.f448256k;
            r109.removeViewAt(r109.f448230n);
            RichTextView r110 = this.f448256k;
            r110.addView(r108, r110.f448230n);
            goto L42
        L41:
            LinkEmojiTextView r111 = (LinkEmojiTextView) r107.getChildAt(r107.f448230n);
            this.f448256k.c(r111);
            r111.G(this.f448256k.f448228l.toString(), r106);
            goto L42
        L34:
            if (CollectionUtils.isEmpty(this.f448246a) == false) goto L37;
            r106 = null;
            goto L38
        L8:
            if (CollectionUtils.isEmpty(this.f448247b) == true) goto L10;
        L24:
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            new ArrayList();
            ArrayList r112 = new ArrayList();
            new ArrayList();
            RecogniseSpansResult r113 = new RecogniseSpansResult(this.f448246a, this.f448247b, this.f448249d, this.f448250e, this.f448251f, this.f448252g, this.f448253h, this.f448254i, this.f448248c, r112, this.f448255j, new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
            RichTextView r114 = this.f448256k;
            r114.addView(RichTextView.b(r114, r114.f448228l.toString(), r113));
            goto L42
        L10:
            if (CollectionUtils.isEmpty(this.f448246a) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448251f) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448252g) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448253h) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448254i) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448248c) == false) goto L24;
            if (CollectionUtils.isEmpty(this.f448255j) == false) goto L24;
            RichTextView r115 = this.f448256k;
            r115.addView(RichTextView.b(r115, r115.f448228l.toString(), null));
            goto L42
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void n() {
            RichTextView.a(this.f448256k, "\n" + UIUtils.getString(this.f448256k.getContext(), R.string.Lark_Legacy_UnknownRichTextTag) + "\n");
        }

        public a(RichTextView r100) {
            this.f448256k = r100;
            this.f448246a = new ArrayList();
            this.f448247b = new ArrayList();
            this.f448248c = new ArrayList();
            this.f448249d = new ArrayList();
            this.f448250e = new ArrayList();
            this.f448251f = new ArrayList();
            this.f448252g = new ArrayList();
            this.f448253h = new ArrayList();
            this.f448254i = new ArrayList();
            this.f448255j = new ArrayList();
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void C(RichTextElement.ItalicProperty r100) {
            if (r100 != null) goto L4;
        L8:
            Log.e("Error richtext italic element");
            return;
        L4:
            if (TextUtils.isEmpty(r100.getContent()) == true) goto L8;
            c(r100);
            RichTextView.a(this.f448256k, r100.getContent());
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void D(RichTextElement.MyAIToolProperty r100) {
            if (r100 != null) goto L5;
            Log.e("Error richtext MyAITool element");
            return;
        L5:
            RichTextView.a(this.f448256k, r100.getTool_id());
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.android.lark.widget.richtext.b
        public final void J(RichTextElement.MediaProperty r110) {
            if (r110 != null) goto L6;
            RichTextView r111 = this.f448256k;
            RichTextView.a(r111, UIUtils.getString(r111.getContext(), R.string.Lark_Legacy_MessagePoVideo));
            Log.e("Error richtext media element");
            return;
        L6:
            RichTextView r100 = this.f448256k;
            if (r100.f448242w == false) goto L12;
            d();
            RichTextView r101 = this.f448256k;
            if (r101.C == true) goto L11;
            RichTextVideoView r102 = new RichTextVideoView(r101.getContext());
            int[] r103 = r102.a(r110.getOriginImage());
            LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
            r104.gravity = 3;
            r104.bottomMargin = UIUtils.dp2px(r101.getContext(), 5.0f);
            r104.width = r103[0];
            r104.height = r103[1];
            r102.setLayoutParams(r104);
            Image r105 = r110.getOriginImage();
            String r106 = r110.getOriginPath();
            r110.getCompressPath();
            r102.setInfo(new RichTextVideoView.a(r105, r106, r110.getUrl(), r110.getDuration()));
            r102.setOnClickListener(new q(r101, r110));
            r102.setOnLongClickListener(new r(r101, r110));
            r102.setOnGenericMotionListener(new s(r101, r110));
            this.f448256k.addView(r102);
        L11:
            this.f448256k.f448230n++;
            return;
        L12:
            RichTextView.a(r100, UIUtils.getString(r100.getContext(), R.string.Lark_Legacy_MessagePoVideo));
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void K(RichTextElement.CodeBlockV2Property r100) {
            Log.e("RichTextView", "error enter");
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void a(RichText r100) {
            d();
        }

        public final void c(RichTextElement.RichTextProperty r100) {
            TextStyleInfo r101 = new TextStyleInfo();
            r101.isIndependent = true;
            StringBuilder r102 = this.f448256k.f448228l;
            int r103 = 0;
            if (r102 != null) goto L5;
            int r104 = 0;
        L6:
            r101.start = r104;
            RichTextView r105 = this.f448256k;
            r101.textSize = (int) r105.f448232p;
            r101.textColor = r105.f448231o;
            r101.type = 4;
            if ((r100 instanceof RichTextElement.BoldProperty) == false) goto L10;
            r101.textStyle = Typeface.create(Typeface.DEFAULT, 1);
            r101.text = ((RichTextElement.BoldProperty) r100).getContent();
        L18:
            int r106 = r101.start;
            String r107 = r101.text;
            if (r107 == null) goto L22;
            r103 = r107.length();
        L22:
            r101.end = r106 + r103;
            this.f448251f.add(r101);
            return;
        L10:
            if ((r100 instanceof RichTextElement.ItalicProperty) == false) goto L13;
            r101.textStyle = Typeface.create(Typeface.DEFAULT, 2);
            r101.text = ((RichTextElement.ItalicProperty) r100).getContent();
            goto L18
        L13:
            if ((r100 instanceof RichTextElement.UnderlineProperty) == false) goto L16;
            r101.textStyle = Typeface.create(Typeface.DEFAULT, 0);
            r101.text = ((RichTextElement.UnderlineProperty) r100).getContent();
            r101.isUnderlineText = true;
            goto L18
        L16:
            if ((r100 instanceof RichTextElement.DashedProperty) == false) goto L18;
            r101.textStyle = Typeface.create(Typeface.DEFAULT, 0);
            r101.text = ((RichTextElement.DashedProperty) r100).getContent();
            goto L18
        L5:
            r104 = r102.toString().length();
            goto L6
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.android.lark.widget.richtext.b
        public final void f(RichTextElement.ImageProperty r110) {
            if (r110 != null) goto L5;
        L73:
            Log.e("Error richtext image element");
            return;
        L5:
            if (CollectionUtils.isEmpty(r110.getUrls()) == true) goto L7;
        L9:
            RichTextView r100 = this.f448256k;
            if (r100.f448240v == false) goto L71;
            int r101 = r100.f448213b;
            if (r101 != 2) goto L14;
            int r102 = 0;
        L17:
            Image r103 = com.ss.android.lark.widget.richtext.d.h(r110, r102);
            if (r103 != null) goto L20;
            return;
        L20:
            d();
            RichTextView r104 = this.f448256k;
            if (r104.C == true) goto L70;
            LKUIRoundableLayout r105 = new LKUIRoundableLayout(r104.getContext(), null);
            r105.setBackground(null);
            r105.setBorderColor(r104.T);
            r105.setBorderWidthInPx(r104.W);
            r105.setRadiusInPx((int) r104.f448226k0);
            ImageView r106 = new ImageView(r104.getContext());
            r105.addView(r106);
            int r107 = r104.f448213b;
            if (r107 != 0) goto L25;
            int r108 = (int) (((double) UIHelper.getWindowWidth(r104.getContext())) * 0.6d);
            int r109 = UIHelper.getWindowWidth(r104.getContext());
        L40:
            int r111 = r108;
            int r112 = (int) (((double) r109) * 0.6d);
        L42:
            if (r103.getWidth() > 0) goto L44;
            int r113 = UIUtils.dp2px(r104.getContext(), 80.0f);
        L45:
            int r114 = r113;
            if (r103.getHeight() > 0) goto L48;
            int r115 = UIUtils.dp2px(r104.getContext(), 80.0f);
        L49:
            int[] r116 = ImageUtils.g(r103.getWidth(), r103.getHeight(), r111, r112, r114, r115);
        L50:
            LinearLayout.LayoutParams r117 = new LinearLayout.LayoutParams(-2, -2);
            r117.gravity = 3;
            r117.bottomMargin = UIUtils.dp2px(r104.getContext(), 5.0f);
            r117.width = r116[0];
            r117.height = r116[1];
            r105.setLayoutParams(r117);
            f r118 = f.a();
            int r119 = r116[0];
            int r120 = r116[1];
            r118.getClass();
            String r121 = "";
            if (TextUtils.isEmpty(r103.getToken()) == true) goto L53;
            String r122 = r103.getKey();
            if (TextUtils.isEmpty(r122) == false) goto L59;
            String r123 = r103.getFirstUrl();
        L61:
            if (TextUtils.isEmpty(r121) == false) goto L66;
            if (TextUtils.isEmpty(r123) == false) goto L66;
        L69:
            r106.setOnClickListener(new n(r104, r103, r106));
            r106.setOnLongClickListener(new o(r104));
            r106.setOnGenericMotionListener(new p(r104, r103, r106));
            r104.addView(r105);
        L66:
            if (TextUtils.isEmpty(r121) == false) goto L68;
            ImageLoader.with(r106.getContext()).load(r123).placeholder(R.color.lkui_N100).error(R.drawable.common_failed_chat_picture).override(r119, r120).centerCrop().into(r106);
            goto L69
        L68:
            ImageLoader.with(r106.getContext()).load(new EncryptImage(r121, r103.getFsUnit(), r103.getCrypto())).placeholder(R.color.lkui_N100).error(R.drawable.common_failed_chat_picture).centerCrop().dontAnimate(false).override(r119, r120).into(r106);
            goto L69
        L59:
            r121 = r122;
            r123 = "";
            goto L61
        L53:
            if (CollectionUtils.isEmpty(r103.getUrls()) == false) goto L55;
            r123 = "";
            goto L61
        L55:
            r123 = (String) ListProtector.get(r103.getUrls(), 0);
            goto L61
        L48:
            r115 = Math.min(UIUtils.dp2px(r104.getContext(), 27.0f), r103.getHeight());
            goto L49
        L44:
            r113 = Math.min(UIUtils.dp2px(r104.getContext(), 27.0f), r103.getWidth());
            goto L45
        L25:
            if (r107 == 1) goto L38;
            if (r107 == 2) goto L36;
            if (r107 != 3) goto L29;
            int r124 = UIHelper.getWindowWidth(r104.getContext());
            int r125 = UIUtils.dp2px(r104.getContext(), 32.0f);
        L37:
            r111 = r124 - r125;
            r112 = 10000;
            goto L42
        L29:
            if (r107 != 4) goto L31;
            r111 = UIHelper.dp2px(230.0f);
            r112 = r111;
            goto L42
        L31:
            if (r107 == 5) goto L33;
            r108 = (int) (((double) UIHelper.getWindowWidth(r104.getContext())) * 0.6d);
            r109 = UIHelper.getWindowWidth(r104.getContext());
            goto L40
        L33:
            int r126 = (int) (((double) UIHelper.getWindowWidth(r104.getContext())) * 0.7d);
            r116 = new int[]{r126, (r103.getHeight() * r126) / r103.getWidth()};
            goto L50
        L36:
            r124 = UIHelper.getWindowWidth(r104.getContext());
            r125 = UIUtils.dp2px(r104.getContext(), 30.0f);
            goto L37
        L38:
            r108 = (int) (((double) UIHelper.getWindowWidth(r104.getContext())) * 0.7d);
            r109 = DeviceUtils.getScreenHeight(r104.getContext());
        L70:
            this.f448256k.f448230n++;
            return;
        L14:
            if (r101 != 1) goto L16;
            r102 = 1;
            goto L17
        L16:
            r102 = 2;
            goto L17
        L71:
            RichTextView.a(r100, UIUtils.getString(r100.getContext(), R.string.Lark_Legacy_MessagePoPhoto));
            return;
        L7:
            if (TextUtils.isEmpty(r110.getOriginKey()) == false) goto L9;
            goto L9
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void i(RichTextElement.ParagraphProperty r100) {
            RichTextView.a(this.f448256k, "\n");
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void r(RichTextElement.EmotionProperty r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (TextUtils.isEmpty(r100.getKey()) == true) goto L17;
            String r101 = EmojiHandler.e(r100.getKey());
            String r102 = r100.getKey();
            Intrinsics.checkNotNullParameter(r102, "key");
            Drawable r103 = EmojiHandler.c(r102, null, null);
            if (r103 == null) goto L14;
            EmojiconInfo r104 = new EmojiconInfo();
            r104.type = 10;
            r104.text = r101;
            StringBuilder r105 = this.f448256k.f448228l;
            if (r105 != null) goto L12;
            int r106 = 0;
        L13:
            r104.start = r106;
            r104.end = r106 + r104.text.length();
            r104.key = r100.getKey();
            r104.drawable = r103;
            ((ArrayList) this.f448255j).add(r104);
            goto L14
        L12:
            r106 = r105.toString().length();
        L14:
            RichTextView.a(this.f448256k, r101);
            return;
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void u(RichTextElement.MentionProperty r100) {
            if (r100 != null) goto L5;
            Log.e("Error richtext mention element");
            return;
        L5:
            String r101 = r100.getContent();
            MentionInfo r102 = new MentionInfo();
            r102.f448580id = r100.getMentionItem().getId();
            r102.text = r100.getContent();
            StringBuilder r103 = this.f448256k.f448228l;
            if (r103 != null) goto L8;
            int r104 = 0;
        L9:
            r102.start = r104;
            r102.end = r104 + r101.length();
            if (this.f448256k.B == false) goto L12;
            r102.type = 11;
        L13:
            ((ArrayList) this.f448248c).add(r102);
            RichTextView.a(this.f448256k, r101);
            return;
        L12:
            r102.type = 8;
            r102.isAuthorized = r100.isAuthorized();
            r102.url = r100.getRedirectUrl();
            goto L13
        L8:
            r104 = r103.toString().length();
            goto L9
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void v(RichTextElement.UnderlineProperty r100) {
            if (r100 != null) goto L4;
        L8:
            Log.e("Error richtext underline element");
            return;
        L4:
            if (TextUtils.isEmpty(r100.getContent()) == true) goto L8;
            c(r100);
            RichTextView.a(this.f448256k, r100.getContent());
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void z(RichTextElement.BoldProperty r100) {
            if (r100 != null) goto L4;
        L8:
            Log.e("Error richtext bold element");
            return;
        L4:
            if (TextUtils.isEmpty(r100.getContent()) == true) goto L8;
            c(r100);
            RichTextView.a(this.f448256k, r100.getContent());
        }

        public static Typeface g(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == false) goto L9;
            if (TextUtils.isEmpty(r101) == false) goto L9;
            return Typeface.DEFAULT;
        L9:
            if (TextUtils.isEmpty(r100) == false) goto L11;
        L13:
            int r102 = 0;
        L15:
            if (TextUtils.isEmpty(r101) == false) goto L17;
        L19:
            if (r102 == 0) goto L34;
            if (r102 == 1) goto L32;
            if (r102 == 2) goto L30;
            if (r102 == 3) goto L28;
            return Typeface.DEFAULT;
        L28:
            return Typeface.create(Typeface.DEFAULT, 3);
        L30:
            return Typeface.create(Typeface.DEFAULT, 2);
        L32:
            return Typeface.create(Typeface.DEFAULT, 1);
        L34:
            return Typeface.DEFAULT;
        L17:
            if (r101.trim().equals("italic") == false) goto L19;
            r102 = r102 + 2;
            goto L19
        L11:
            if (r100.trim().equals(CommodityText.BOLD) == false) goto L13;
            r102 = 1;
            goto L15
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void N(RichTextElement.TextProperty r100, Map<String, String> r101) {
            if (r100 != null) goto L6;
            Log.e("Error richtext text element");
            return;
        L6:
            if ((r100 instanceof RichTextElement.DashedProperty) == false) goto L12;
            RichTextElement.DashedProperty r102 = (RichTextElement.DashedProperty) r100;
            AbbreviationInfo r103 = new AbbreviationInfo();
            int r104 = 0;
            r103.isIndependent = false;
            r103.f448571id = r102.f448198id;
            r103.desc = r102.i18nDesc;
            r103.fullName = r102.fullName;
            r103.name = r102.name;
            r103.text = r102.content;
            StringBuilder r105 = this.f448256k.f448228l;
            if (r105 == null) goto L11;
            r104 = r105.toString().length();
        L11:
            r103.start = r104;
            r103.end = r104 + r102.content.length();
            r103.textColor = UIUtils.getColor(this.f448256k.getContext(), R.color.primary_fill_default);
            r103.textSize = (int) this.f448256k.f448232p;
            r103.type = 5;
            r103.chatId = r102.chatId;
            r103.messageId = r102.messageId;
            r103.textStyle = g(r101.get("fontWeight"), r101.get("fontStyle"));
            r103.intervalOff = r102.intervalOff;
            r103.intervalOn = r102.intervalOn;
            ((ArrayList) this.f448252g).add(r103);
        L12:
            RichTextView.a(this.f448256k, r100.getContent());
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void m(RichTextElement.AnchorProperty r100, Map<String, String> r101) {
            if (r100 != null) goto L4;
        L51:
            Log.e("Error richtext anchor element");
            return;
        L4:
            if (TextUtils.isEmpty(r100.getContent()) == true) goto L51;
            int r102 = 0;
            if (TextUtils.isEmpty(r100.getIconKey()) == true) goto L16;
            if (TextUtils.isEmpty(r100.getDisplayTitle()) == true) goto L16;
            KeyIconUrlInfo r103 = new KeyIconUrlInfo();
            r103.iconKey = r100.getIconKey();
            r103.placeHolderRes = r100.getLocalIconRes();
            r103.greyPlaceHolderRes = r100.getLocalGrayIconRes();
            r103.isUrlPreview = r100.isUrlPreview();
            r103.text = "$" + r100.getDisplayTitle() + " ";
            StringBuilder r104 = this.f448256k.f448228l;
            if (r104 != null) goto L13;
            int r105 = 0;
        L14:
            r103.start = r105;
            r103.end = r105 + r103.text.length();
            UrlInfo r106 = r103;
        L29:
            r106.type = 1;
            r106.href = r100.getHref();
            r106.isUnderlineText = this.f448256k.f448241v1;
            ((ArrayList) this.f448246a).add(r106);
            String r107 = r100.getContent();
            if (CollectionUtils.isEmpty(r101) == true) goto L40;
            if (TextUtils.isEmpty(r107) == true) goto L40;
            TextStyleInfo r108 = new TextStyleInfo();
            r108.isIndependent = false;
            r108.text = r107;
            StringBuilder r109 = this.f448256k.f448228l;
            if (r109 == null) goto L38;
            r102 = r109.toString().length();
        L38:
            r108.start = r102;
            r108.end = r102 + r107.length();
            r108.textColor = UIUtils.getColor(this.f448256k.getContext(), R.color.primary_fill_default);
            r108.textSize = (int) this.f448256k.f448232p;
            r108.type = 4;
            r108.textStyle = g(r101.get("fontWeight"), r101.get("fontStyle"));
            ((ArrayList) this.f448251f).add(r108);
        L40:
            if (TextUtils.isEmpty(r100.getIconKey()) == true) goto L45;
            if (TextUtils.isEmpty(r100.getDisplayTitle()) == true) goto L45;
            RichTextView.a(this.f448256k, "$" + r100.getDisplayTitle() + " ");
            return;
        L45:
            if (r100.getLocalIconRes() > 0) goto L47;
        L49:
            RichTextView.a(this.f448256k, r100.getContent());
            return;
        L47:
            if (TextUtils.isEmpty(r100.getDisplayTitle()) == true) goto L49;
            RichTextView.a(this.f448256k, "$" + r100.getDisplayTitle() + " ");
            return;
        L13:
            r105 = r104.toString().length();
        L16:
            if (r100.getLocalIconRes() > 0) goto L18;
        L24:
            UrlInfo r110 = new UrlInfo();
            r110.text = r100.getContent();
            StringBuilder r111 = this.f448256k.f448228l;
            if (r111 != null) goto L27;
            int r112 = 0;
        L28:
            r110.start = r112;
            r110.end = r112 + r100.getContent().length();
            r106 = r110;
            goto L29
        L27:
            r112 = r111.toString().length();
            goto L28
        L18:
            if (TextUtils.isEmpty(r100.getDisplayTitle()) == true) goto L24;
            RichUrlInfo r113 = new RichUrlInfo();
            r113.mLocalImageResId = r100.getLocalIconRes();
            r113.mDisplayTitle = r100.getDisplayTitle();
            r113.text = "$" + r100.getDisplayTitle() + " ";
            StringBuilder r114 = this.f448256k.f448228l;
            if (r114 != null) goto L22;
            int r115 = 0;
        L23:
            r113.start = r115;
            r113.end = r115 + r113.text.length();
            r106 = r113;
            goto L29
        L22:
            r115 = r114.toString().length();
            goto L23
        }

        @Override // com.ss.android.lark.widget.richtext.b
        public final void t(RichTextElement.AtProperty r100, Map<String, String> r101) {
            if (r100 != null) goto L5;
            Log.e("Error richtext at element");
            return;
        L5:
            String r102 = com.ss.android.lark.utils.o.a(r100.getUserId(), r100.getAtContent().substring(1));
            AtInfo r103 = new AtInfo();
            int r104 = 0;
            r103.type = 0;
            r103.userId = r100.getUserId();
            r103.text = r100.getAtContent();
            StringBuilder r105 = this.f448256k.f448228l;
            if (r105 == null) goto L9;
            r104 = r105.toString().length();
        L9:
            r103.start = r104;
            r103.end = r104 + r102.length();
            r103.isOutChatUser = r100.isOutChatUser();
            r103.isAnonymous = r100.isAnonymous();
            ((ArrayList) this.f448247b).add(r103);
            RichTextView.a(this.f448256k, r102);
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void a();

        void b();
    }

    public interface e {
    }

    public void setOnEllipsizeListener(b r100) {
    }

    public void setRichTextImageListener(c r100) {
    }

    public void setRichTextVideoListener(e r100) {
    }

    private int getFontSize() {
        if (this.f448235q == false) goto L7;
        float r100 = zz7.b.h(getContext(), UIHelper.px2dp(this.f448232p));
    L6:
        return (int) r100;
    L7:
        r100 = this.f448232p;
        goto L6
    }

    private int getImageFlag() {
        int r100 = this.f448213b;
        if (r100 != 2) goto L6;
        return 0;
    L6:
        if (r100 != 1) goto L10;
        return 1;
    L10:
        return 2;
    }

    private LKUILightTextView getLKUILightTextView() {
        if (getChildCount() == 0) goto L8;
        View r100 = getChildAt(0);
        if ((r100 instanceof LKUILightTextView) == false) goto L8;
        return (LKUILightTextView) r100;
    L8:
        LKUILightTextView r101 = new LKUILightTextView(getContext());
        r101.setTextSize(getFontSize());
        r101.setTextColor(this.f448231o);
        r101.setSpacingMulti(this.H);
        r101.setSpacingExtra(this.G);
        r101.setHighlightedColor(this.M);
        r101.setIncludeFontPadding(this.f448214b1);
        r101.setFakeBoldText(this.V0);
        addView(r101);
        return r101;
    }

    public RichTextView(Context r100) {
        this(r100, null);
    }

    private void setLinkEmojiTextViewListener(LinkEmojiTextView r100) {
        LinkEmojiTextView.h r101 = this.f448221h;
        if (r101 == null) goto L5;
        r100.setPhoneStringClickListener(r101);
    L5:
        LinkEmojiTextView.i r102 = this.f448215c;
        if (r102 == null) goto L8;
        r100.setUrlStringClickListner(r102);
    L8:
        LinkEmojiTextView.f r103 = this.f448217e;
        if (r103 == null) goto L11;
        r100.setAtStringClickListner(r103);
    L11:
        mcc.i r104 = this.f448218f;
        if (r104 == null) goto L14;
        r100.setMentionSpanClickListener(r104);
    L14:
        mcc.j r105 = this.f448219g;
        if (r105 == null) goto L17;
        r100.setHashTagSpanClickListener(r105);
    L17:
        LinkEmojiTextView.e r106 = this.f448223i;
        if (r106 == null) goto L21;
        r100.setAbbreviationClickListener(r106);
        return;
    }

    private void setTextStrikeThrough(LinkEmojiTextView r100) {
        if (this.f448227k1 == true) goto L5;
        return;
    L5:
        if (r100.getPaint() == null) goto L9;
        r100.getPaint().setFlags(17);
        return;
    }

    private void setupLightTextView(RichText r100) {
        if (i.l(r100) == false) goto L6;
        getLKUILightTextView().setContentText("");
        return;
    L6:
        lec.b.a r101 = new lec.b.a();
        r101.f509001b = this.f448240v;
        r101.f509002c = this.f448242w;
        r101.f509004e = this.B;
        int r102 = 0;
        r101.f509003d = false;
        if (this.W == 0.0f) goto L9;
        boolean r103 = true;
    L10:
        r101.f509008i = r103;
        int r104 = this.f448213b;
        if (r104 != 1) goto L13;
        r102 = 1;
    L26:
        r101.f509007h = r102;
        r101.f509010k = this.f448233p0;
        r101.f509014o = this.f448243x;
        r101.f509000a = this.A;
        r101.f509005f = this.f448244y;
        r101.f509006g = this.f448245z;
        lec.b r105 = new lec.b(r101);
        lec.e r106 = lec.d.a(getContext(), r100, r105);
        ArrayList r107 = new ArrayList();
        boolean r108 = this.f448220g1;
        List<SpanInfo> r109 = r106.f509021b.getAllSpanInfos();
        if (CollectionUtils.isNotEmpty(r109) == false) goto L29;
        r107.addAll(r109);
    L29:
        Pattern r110 = g0.f448681d;
        g0 r111 = g0.a.f448687a;
        String r112 = r106.f509020a;
        r111.getClass();
        if (TextUtils.isEmpty(r112) == true) goto L35;
        if (r108 == false) goto L34;
        g0.a(r107, r111.f(r112, r107));
    L34:
        Collections.sort(r107);
    L35:
        com.ss.android.lark.widget.light.e.a r113 = new com.ss.android.lark.widget.light.e.a(getContext());
        r113.f446012c = this.f448233p0;
        List<String> r114 = this.f448239u;
        Intrinsics.checkNotNullParameter(r114, "atReadUserList");
        CollectionUtils.resetToList(r113.f446010a, r114);
        List<String> r115 = this.f448238t;
        Intrinsics.checkNotNullParameter(r115, "botIdList");
        CollectionUtils.resetToList(r113.f446011b, r115);
        r113.f446019j = zz7.b.g(getContext(), 20);
        if (this.O == 0) goto L39;
        r113.f446030u = UIUtils.getColor(getContext(), this.O);
    L39:
        if (this.P == 0) goto L42;
        r113.f446029t = UIUtils.getColor(getContext(), this.P);
    L42:
        if (this.Q == 0) goto L45;
        r113.f446031v = UIUtils.getColor(getContext(), this.Q);
    L45:
        if (this.R == 0) goto L48;
        r113.f446028s = UIUtils.getColor(getContext(), this.R);
    L48:
        if (this.U == 0) goto L51;
        r113.f446032w = UIUtils.getColor(getContext(), this.U);
    L51:
        if (this.V == 0) goto L53;
        r113.f446033x = UIUtils.getColor(getContext(), this.V);
    L53:
        r113.f446016g = getFontSize();
        r113.a(xbc.d.a().getUserId());
        if (this.f448227k1 == false) goto L56;
        r113.f446023n = true;
    L56:
        com.ss.android.lark.widget.light.e r116 = new com.ss.android.lark.widget.light.e(r113);
        CharSequence r117 = com.ss.android.lark.widget.light.f.a.f446037a.b(getContext(), r106.f509020a, r107, r116);
        LKUILightTextView r118 = getLKUILightTextView();
        int r119 = this.f448236r;
        if (r119 == (-1)) goto L59;
        r118.setMaxLines(r119);
        r118.setEllipsize(TextUtils.TruncateAt.END);
    L59:
        String r120 = r117.toString();
        if (this.f448221h == null) goto L63;
        r118.setPhoneSpanClickListener(new t(this));
    L63:
        if (this.f448216d == null) goto L66;
        r118.setUrlSpanClickListener(new u(this));
    L69:
        if (this.f448217e == null) goto L72;
        r118.setAtSpanClickListener(new w(this));
    L72:
        if (this.f448218f == null) goto L75;
        r118.setMentionSpanClickListener(new x(this));
    L75:
        if (this.f448219g == null) goto L78;
        r118.setHashTagSpanClickListener(new y(this));
    L78:
        if (this.f448223i == null) goto L81;
        r118.setAbbreviationClickListener(new z(this));
    L81:
        if (this.f448224j == null) goto L84;
        r118.setAtUserGroupSpanClickListener(new a0(this));
    L84:
        if (this.f448225k == null) goto L86;
        TextView r121 = new TextView(getContext());
        r118.setOnClickListener(new k(this, r121));
        r118.setOnLongClickListener(new l(this, r120, r121));
    L86:
        r118.setContentText(r117);
        return;
    L66:
        if (this.f448215c == null) goto L69;
        r118.setUrlSpanClickListener(new v(this));
        goto L69
    L13:
        if (r104 != 3) goto L15;
        r102 = 2;
        goto L26
    L15:
        if (r104 != 4) goto L17;
        r102 = 3;
        goto L26
    L17:
        if (r104 != 5) goto L19;
        r102 = 4;
        goto L26
    L19:
        if (r104 != 6) goto L26;
        r102 = 5;
        goto L26
    L9:
        r103 = false;
        goto L10
    }

    public final void c(LinkEmojiTextView r100) {
        com.ss.android.lark.widget.linked_emojicon.widget.c r101 = r100.getHelper();
        r101.f446444c = this.f448233p0;
        com.ss.android.lark.widget.linked_emojicon.widget.c r102 = r100.getHelper();
        List<String> r103 = this.f448238t;
        r102.getClass();
        if (CollectionUtils.isNotEmpty(r103) == false) goto L5;
        r102.f446445d = r103;
    L5:
        com.ss.android.lark.widget.linked_emojicon.widget.c r104 = r100.getHelper();
        List<String> r105 = this.f448239u;
        CollectionUtils.resetToList(r104.f446443b, r105);
    }

    public void setAbbreviationListener(LinkEmojiTextView.e r100) {
        this.f448223i = r100;
    }

    public void setAtOtherChatUserBgColor(int r100) {
        this.S = r100;
    }

    public void setAtOtherChatUserTextColor(int r100) {
        this.R = r100;
    }

    public void setAtReadUserIdList(List<String> r100) {
        if (r100 == null) goto L5;
        CollectionUtils.resetToList(this.f448239u, r100);
        return;
    }

    public void setAtSelfBgColor(int r100) {
        this.O = r100;
    }

    public void setAtSelfTextColor(int r100) {
        this.P = r100;
    }

    public void setAtStringClickListner(LinkEmojiTextView.f r100) {
        this.f448217e = r100;
    }

    public void setAtTextColor(int r100) {
        this.Q = r100;
    }

    public void setAtUserGroupClickListener(mcc.c r100) {
        this.f448224j = r100;
    }

    public void setBotIdList(List<String> r100) {
        this.f448238t = r100;
    }

    public void setDefaultAtUserColor(int r100) {
        this.N = r100;
    }

    public void setDotReadColor(int r100) {
        this.U = r100;
    }

    public void setDotUnreadColor(int r100) {
        this.V = r100;
    }

    public void setEllipsisAtCurrentChatter(boolean r100) {
        this.A = r100;
    }

    public void setEmojIconSize(int r100) {
        this.I = r100;
    }

    public void setEnableSelectText(boolean r100) {
        this.H0 = r100;
    }

    public void setFakeBoldText(boolean r100) {
        this.V0 = r100;
    }

    public void setFontAutoResize(boolean r100) {
        this.f448235q = r100;
    }

    public void setHighlightColor(int r100) {
        this.M = r100;
    }

    public void setImageBoarderRadius(float r100) {
        this.f448226k0 = r100;
    }

    public void setImageBorderColor(int r100) {
        this.T = r100;
    }

    public void setImageBorderWidth(float r100) {
        this.W = r100;
    }

    public void setImageMode(int r100) {
        this.f448213b = r100;
    }

    public void setIncludeFontPadding(boolean r100) {
        this.f448214b1 = r100;
    }

    public void setInfo(RichText r100) {
        d(r100, "", false);
    }

    public void setIsTextStrikeThrough(boolean r100) {
        this.f448227k1 = r100;
    }

    public void setIsUrlShowUnderLine(boolean r100) {
        this.f448241v1 = r100;
    }

    public void setMaxLines(int r100) {
        if (r100 <= 0) goto L5;
        this.f448236r = r100;
        return;
    }

    public void setMentionListener(mcc.i r100) {
        this.f448218f = r100;
    }

    public void setMomentsHashTagListener(mcc.j r100) {
        this.f448219g = r100;
    }

    public void setNeedShowAtDot(boolean r100) {
        this.f448233p0 = r100;
    }

    public void setNeedToRecognizePhone(boolean r100) {
        this.f448220g1 = r100;
    }

    public void setPhoneStringClickListener(LinkEmojiTextView.h r100) {
        this.f448221h = r100;
    }

    public void setPhoneTextColor(int r100) {
        this.L = r100;
    }

    public void setRichTextListener(d r100) {
        this.f448225k = r100;
    }

    public void setShowCodeBlockV2(boolean r100) {
        this.f448243x = r100;
    }

    public void setShowColumnsDetail(boolean r100) {
        this.f448245z = r100;
    }

    public void setShowImage(boolean r100) {
        this.f448240v = r100;
    }

    public void setShowMomentsHashtag(boolean r100) {
        this.B = r100;
    }

    public void setShowShortTailText(boolean r100) {
        this.f448212a = r100;
    }

    public void setShowTableDetail(boolean r100) {
        this.f448244y = r100;
    }

    public void setShowVideo(boolean r100) {
        this.f448242w = r100;
    }

    public void setTextColor(int r100) {
        this.f448231o = r100;
        Boolean r101 = f448210x1;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.booleanValue() == false) goto L9;
        getLKUILightTextView().setTextColor(r100);
        return;
    }

    public void setTextSize(float r100) {
        this.f448232p = r100;
    }

    public void setTranslateEmojiText(boolean r100) {
        this.f448222h1 = r100;
    }

    public void setUrlSpanClickListener(mcc.o r100) {
        this.f448216d = r100;
    }

    public void setUrlStringClickListner(LinkEmojiTextView.i r100) {
        this.f448215c = r100;
    }

    public void setUrlTextColor(int r100) {
        this.f448211J = r100;
    }

    public void setUseNewAtStyle(boolean r100) {
        this.P0 = r100;
    }

    public void setUserLightTextView(boolean r100) {
        f448210x1 = Boolean.valueOf(r100);
    }

    public RichTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(RichTextView r100, String r101) {
        StringBuilder r102 = r100.f448228l;
        if (r102 == null) goto L5;
        r102.append(r101);
        return;
    L5:
        if (r101.equals("\n") == false) goto L7;
        r101 = "";
    L7:
        r100.f448228l = new StringBuilder(r101);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f448237s == false) goto L35;
        int r102 = this.f448236r;
        if (r102 != (-1)) goto L7;
        boolean r103 = false;
    L26:
        if (r103 == false) goto L36;
        super.onMeasure(r100, r101);
        this.f448237s = false;
        return;
    L36:
        return;
    L7:
        int r104 = 0;
        r103 = false;
    L9:
        if (r104 >= getChildCount()) goto L26;
        View r105 = getChildAt(r104);
        if (r103 == false) goto L13;
        r105.setVisibility(8);
    L25:
        r104 = r104 + 1;
        goto L9
    L13:
        r105.setVisibility(0);
        if ((r105 instanceof LinkEmojiTextView) == false) goto L20;
        LinkEmojiTextView r106 = (LinkEmojiTextView) r105;
        if (r102 < r106.getLineCount()) goto L18;
        r102 = r102 - r106.getLineCount();
        goto L25
    L18:
        r106.setShowTail(true);
        r106.setShowShortTailText(this.f448212a);
        r106.setMaxLines(r102);
    L24:
        r103 = true;
        goto L25
    L20:
        if ((r105 instanceof ComposeImageView) == false) goto L25;
        if (r102 <= 3) goto L24;
        r102 = r102 - 3;
        goto L25
    }

    public RichTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448212a = true;
        this.f448213b = 0;
        this.f448230n = 0;
        this.f448235q = true;
        this.f448236r = -1;
        this.f448237s = false;
        this.f448238t = new ArrayList();
        this.f448239u = new ArrayList();
        this.f448240v = true;
        this.f448242w = true;
        this.f448243x = true;
        this.f448244y = false;
        this.f448245z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = -1;
        this.F = true;
        this.f448233p0 = false;
        this.H0 = xbc.d.a().isTextSelectable();
        this.L0 = "";
        this.P0 = false;
        this.V0 = false;
        this.f448214b1 = true;
        this.f448220g1 = true;
        this.f448222h1 = false;
        this.f448227k1 = false;
        this.f448234p1 = new a(this);
        this.f448241v1 = false;
        this.f448231o = UIUtils.getColor(r100, R.color.text_title);
        this.f448232p = UIUtils.sp2px(r100, 16.0f);
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.emojiconSize, R.attr.highlightColor, R.attr.imageBorderColor, R.attr.imageBorderRadius, R.attr.imageBorderWidthDp, R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier, R.attr.phoneTextColor, R.attr.richTextColor, R.attr.richTextSize, R.attr.showImage, R.attr.showUrlUnderLine, R.attr.urlBackGroundColor, R.attr.urlTextColor});
        this.f448232p = r103.getDimensionPixelSize(9, (int) UIUtils.sp2px(r100, 16.0f));
        this.G = r103.getDimensionPixelSize(5, UIUtils.getDimens(r100, R.dimen.text_default_line_spacing));
        this.H = r103.getFloat(6, 1.0f);
        this.I = r103.getDimensionPixelSize(0, zz7.b.g(r100, 19));
        this.f448231o = r103.getColor(8, UIUtils.getColor(r100, R.color.text_title));
        this.f448211J = r103.getColor(13, UIUtils.getColor(r100, R.color.text_link_normal));
        this.K = r103.getColor(12, UIUtils.getColor(r100, R.color.bg_base));
        this.L = r103.getColor(7, UIUtils.getColor(r100, R.color.text_link_normal));
        this.F = r103.getBoolean(11, true);
        this.f448240v = r103.getBoolean(10, true);
        this.M = r103.getColor(1, 1714664933);
        this.T = r103.getColor(2, UIUtils.getColor(getContext(), R.color.static_white));
        this.W = r103.getDimension(4, 0.0f);
        this.f448226k0 = r103.getDimension(3, 0.0f);
        r103.recycle();
        setOrientation(1);
        setDividerDrawable(getContext().getResources().getDrawable(R.drawable.divider_linearlayout_vertical));
        setShowDividers(2);
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [com.ss.android.lark.widget.richtext.e] */
    public static LinkEmojiTextView b(final RichTextView r100, final String r101, RecogniseSpansResult r102) {
        Context r103 = r100.getContext();
        LinkEmojiTextView.i r104 = r100.f448215c;
        LinkEmojiTextView.f r105 = r100.f448217e;
        final LinkEmojiTextView r106 = new LinkEmojiTextView(r103);
        r106.setUrlTextColor(r103.getResources().getColor(R.color.text_link_normal));
        r106.setUrlBackGroundColor(r103.getResources().getColor(R.color.bg_base));
        r106.setCurrentUserId(xbc.d.a().getUserId());
        r106.setUrlStringClickListner(r104);
        r106.setAtStringClickListner(r105);
        r106.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r106.setTextIsSelectable(r100.H0);
        r106.setUseNewAtStyle(r100.P0);
        r106.setTextSize(0, r100.f448232p);
        r106.setLineSpacing(r100.G, r100.H);
        r106.setEmojiconSize(r100.I);
        r106.setEmojiconTextSize((int) r100.f448232p);
        r106.setTranslateEmojiCode(r100.f448222h1);
        r100.setTextStrikeThrough(r106);
        r106.setTextColor(r100.f448231o);
        r106.setHighlightColor(r100.M);
        r106.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        r106.setUrlTextColor(r100.f448211J);
        r106.setUrlBackGroundColor(r100.K);
        r106.setCurrentUserId(xbc.d.a().getUserId());
        r106.setPhoneTextColor(r100.L);
        r106.setShowUrlUnderLine(r100.F);
        r106.setIsUrlShowUnderLine(r100.f448241v1);
        r106.setAtTextColor(r100.Q);
        r106.setAtSelfTextColor(r100.P);
        r106.setAtSelfBgColor(r100.O);
        r106.setAtOtherChatUserTextColor(r100.R);
        r106.setAtOtherChatUserBgColor(r100.S);
        r106.setDefaultAtUserColor(r100.N);
        int r107 = r100.U;
        if (r107 == 0) goto L5;
        r106.setDotReadColor(r107);
    L5:
        int r108 = r100.V;
        if (r108 == 0) goto L9;
        r106.setDotUnreadColor(r108);
    L9:
        if (r100.V0 == true) goto L11;
    L13:
        r106.setIncludeFontPadding(r100.f448214b1);
        r106.setNeedToRecognizePhone(r100.f448220g1);
        r100.setLinkEmojiTextViewListener(r106);
        r100.c(r106);
        r106.setOnClickListener(new m(r100, r106));
        r106.setOnLongClickListener(new j(r100, r101, r106));
        f.a().getClass();
        if (f.f448311b != null) goto L16;
        f.f448311b = new com.ss.android.lark.widget.richtext.e();
    L16:
        r106.setImageFetcher(f.f448311b);
        r106.G(r101, r102);
        return r106;
    L11:
        if (r106.getPaint() == null) goto L13;
        r106.getPaint().setFakeBoldText(r100.V0);
        goto L13
    }

    public final void d(RichText r100, String r101, boolean r102) {
        if (f448210x1 != null) goto L6;
        f448210x1 = Boolean.valueOf(xbc.d.a().isUseLightTextView());
        Log.i("RichTextView", "useLightTextView:" + f448210x1);
    L6:
        if (f448210x1.booleanValue() == false) goto L9;
        setupLightTextView(r100);
        return;
    L9:
        boolean r103 = CollectionUtils.isNotEmpty(this.f448239u);
        RichText r104 = this.f448229m;
        if (r104 != null) goto L12;
    L16:
        boolean r105 = false;
    L17:
        if (r102 == true) goto L36;
        if (r103 == true) goto L36;
        if (r105 == false) goto L36;
        List<String> r106 = r100.getAnchorIds();
        if (r106 != null) goto L23;
    L33:
        boolean r107 = false;
    L34:
        if (r107 == true) goto L36;
        return;
    L23:
        if (r106.size() <= 0) goto L33;
        RichTextElement r108 = r100.getElements().getDictionary().get(ListProtector.get(r106, 0));
        if (r108 == null) goto L33;
        if ((r108.getProperty() instanceof RichTextElement.AnchorProperty) == false) goto L33;
        int r109 = ((RichTextElement.AnchorProperty) r108.getProperty()).getVersion();
        if (r109 < this.E) goto L33;
        this.E = r109;
        r107 = true;
    L36:
        if (r105 == true) goto L38;
    L40:
        this.f448230n = 0;
        this.C = false;
        this.f448229m = r100;
        removeAllViews();
    L41:
        this.D = r102;
        this.f448237s = true;
        this.L0 = r101;
        g.b(r100, this.f448234p1);
        return;
    L38:
        if (this.f448236r != (-1)) goto L40;
        this.f448230n = 0;
        this.C = true;
        goto L41
    L12:
        if (r104.equals(r100) == false) goto L16;
        if (Objects.equals(this.L0, r101) == false) goto L16;
        r105 = true;
        goto L17
    }
}
