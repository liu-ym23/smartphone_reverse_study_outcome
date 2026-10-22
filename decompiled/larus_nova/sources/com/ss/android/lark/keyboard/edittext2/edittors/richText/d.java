package com.ss.android.lark.keyboard.edittext2.edittors.richText;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.KeyboardBaseModule;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.keyboard.edittext2.span.j;
import com.ss.android.lark.keyboard.edittext2.utils.e;
import com.ss.android.lark.keyboard.edittext2.utils.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.light.span.p;
import com.ss.android.lark.widget.linked_emojicon.base.EmojiHandler;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.RichTextExtraInfo;
import com.ss.android.lark.widget.span.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public class d implements com.ss.android.lark.keyboard.edittext2.base.a, com.ss.android.lark.keyboard.edittext2.base.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f429100g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f429101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f429102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.edittext2.base.b f429103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f429104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f429105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f429106f;

    public static final class a implements com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.keyboard.edittext2.base.d f429107a;

        @Override // com.ss.android.lark.keyboard.edittext2.base.a.InterfaceC5085a
        public final Class<d> a() {
            return this.f429107a.f428961a;
        }

        public a() {
            this.f429107a = new com.ss.android.lark.keyboard.edittext2.base.d(d.class);
        }
    }

    public static class b implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f429108a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f429109a = null;

            static {
                int[] r100 = new int[RichTextElement.RichTextTag.values().length];
                r100[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L35:
                r100[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L51:
                r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L39:
                r100[RichTextElement.RichTextTag.EMOTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            L43:
                r100[RichTextElement.RichTextTag.IMG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
            L29:
                r100[RichTextElement.RichTextTag.MEDIA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
            L45:
                r100[RichTextElement.RichTextTag.MENTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            L47:
                r100[RichTextElement.RichTextTag.CODE_BLOCK_V2.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
            L37:
                r100[RichTextElement.RichTextTag.TABLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
            L41:
                r100[RichTextElement.RichTextTag.COLUMNS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
            L31:
                r100[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
            L33:
                r100[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
            L15:
                f429109a = r100;
            }
        }

        public b(d r100) {
            Intrinsics.checkNotNullParameter(r100, "generator");
            this.f429108a = r100;
        }

        @Override // com.ss.android.lark.keyboard.edittext2.utils.f.a
        public final RichTextElement a(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "span");
            if ((r100 instanceof p) == false) goto L27;
            Object r101 = ((p) r100).f446280b;
            if ((r101 instanceof RichTextElement) == false) goto L27;
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
            RichTextElement r102 = (RichTextElement) r101;
            RichTextElement.RichTextTag r103 = r102.getTag();
            if (r103 != null) goto L10;
            int r104 = -1;
        L11:
            switch(r104) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L38;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L14;
                case 12: goto L13;
                default: goto L28;
            };
        L13:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "markdownElement");
            return r102;
        L14:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "userGroupElement");
            return r102;
        L15:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "columnsElement");
            return r102;
        L16:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "tableElement");
            return r102;
        L17:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "codeBlockV2Element");
            return r102;
        L18:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "mentionElement");
            return r102;
        L19:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "mediaElement");
            return r102;
        L20:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "imgElement");
            return r102;
        L21:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "emotionElement");
            return r102;
        L23:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "atElement");
            return r102;
        L24:
            this.f429108a.getClass();
            Intrinsics.checkNotNullParameter(r102, "textElement");
            return r102;
        L28:
            return this.f429108a.g(r100);
        L38:
            return this.f429108a.f(r102);
        L10:
            r104 = a.f429109a[r103.ordinal()];
        L27:
            return this.f429108a.g(r100);
        }

        @Override // com.ss.android.lark.widget.richtext.a
        public final void e(Spanned r100, List<Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "editable");
            Intrinsics.checkNotNullParameter(r101, "spans");
            this.f429108a.p(r100, r101);
        }

        @Override // com.ss.android.lark.widget.richtext.a
        public final boolean c(Spannable r100, Object r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "editable");
            Intrinsics.checkNotNullParameter(r101, "span");
            return this.f429108a.o(r100, r101, r102, r103);
        }
    }

    public static class c implements com.ss.android.lark.widget.richtext.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f429110a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f429111a = null;

            static {
                int[] r100 = new int[RichTextElement.RichTextTag.values().length];
                r100[RichTextElement.RichTextTag.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
            L35:
                r100[RichTextElement.RichTextTag.AT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
            L51:
                r100[RichTextElement.RichTextTag.ANCHOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
            L39:
                r100[RichTextElement.RichTextTag.EMOTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            L43:
                r100[RichTextElement.RichTextTag.IMG.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
            L29:
                r100[RichTextElement.RichTextTag.MEDIA.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
            L45:
                r100[RichTextElement.RichTextTag.MENTION.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
            L47:
                r100[RichTextElement.RichTextTag.CODE_BLOCK_V2.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
            L37:
                r100[RichTextElement.RichTextTag.TABLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
            L41:
                r100[RichTextElement.RichTextTag.COLUMNS.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
            L31:
                r100[RichTextElement.RichTextTag.AT_USER_GROUP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
            L33:
                r100[RichTextElement.RichTextTag.MARKDOWN.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
            L15:
                f429111a = r100;
            }
        }

        public c(d r100) {
            Intrinsics.checkNotNullParameter(r100, "generator");
            this.f429110a = r100;
        }

        @Override // com.ss.android.lark.widget.richtext.a
        public final void e(Spanned r100, List<Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "editable");
            Intrinsics.checkNotNullParameter(r101, "spans");
            this.f429110a.q(r100, r101);
        }

        public final String g(Object r100, CharSequence r101) {
            Intrinsics.checkNotNullParameter(r100, "span");
            Intrinsics.checkNotNullParameter(r101, "sequence");
            if ((r100 instanceof p) == false) goto L38;
            Object r102 = ((p) r100).f446280b;
            if ((r102 instanceof RichTextElement) == false) goto L38;
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.widget.richtext.RichTextElement");
            RichTextElement r103 = (RichTextElement) r102;
            RichTextElement.RichTextTag r104 = r103.getTag();
            if (r104 != null) goto L10;
            int r105 = -1;
        L11:
            List<LineContent> r106 = null;
            String r107 = null;
            switch(r105) {
                case 1: goto L35;
                case 2: goto L34;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L22;
                case 9: goto L21;
                case 10: goto L20;
                case 11: goto L19;
                case 12: goto L14;
                default: goto L39;
            };
        L14:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "markdownElement");
            RichTextElement.MarkdownProperty r108 = (RichTextElement.MarkdownProperty) r103.getProperty();
            if (r108 == null) goto L17;
            r107 = r108.getContent();
        L17:
            if (r107 != null) goto L40;
            return "";
        L40:
            return r107;
        L19:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "userGroupElement");
            return ((RichTextElement.AtUserGroupProperty) r103.getProperty()).getAtContent();
        L20:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "columnsElement");
            int r109 = dcc.a.f467914a;
            return UIHelper.getString(R.string.Lark_IM_ColumnInChat_PushTitle_Text);
        L21:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "tableElement");
            return uec.a.a();
        L22:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "codeBlockV2Element");
            RichTextElement.CodeBlockV2Property r110 = (RichTextElement.CodeBlockV2Property) r103.getProperty();
            if (r110 == null) goto L25;
            r106 = r110.getLineContents();
        L25:
            String r111 = com.ss.android.lark.widget.codeblock.entity.a.a(r106);
            if (StringsKt.isBlank(r111) == false) goto L45;
            r111 = com.ss.android.lark.widget.codeblock.entity.a.b();
        L45:
            return r111;
        L29:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "mentionElement");
            return ((RichTextElement.MentionProperty) r103.getProperty()).getContent();
        L30:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "mediaElement");
            return UIHelper.getString(R.string.Lark_Legacy_MessagePoVideo);
        L31:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "imgElement");
            return UIHelper.getString(R.string.Lark_Legacy_ImageSummarize);
        L32:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "emotionElement");
            return EmojiHandler.f(((RichTextElement.EmotionProperty) r103.getProperty()).getKey());
        L33:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "anchorElement");
            return ((RichTextElement.AnchorProperty) r103.getProperty()).getHref();
        L34:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "atElement");
            return ((RichTextElement.AtProperty) r103.getProperty()).getAtContent();
        L35:
            this.f429110a.getClass();
            Intrinsics.checkNotNullParameter(r103, "textElement");
            return ((RichTextElement.TextProperty) r103.getProperty()).getContent();
        L39:
            return this.f429110a.h(r100, r101);
        L10:
            r105 = a.f429111a[r104.ordinal()];
        L38:
            return this.f429110a.h(r100, r101);
        }

        @Override // com.ss.android.lark.widget.richtext.a
        public final boolean c(Spannable r100, Object r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "editable");
            Intrinsics.checkNotNullParameter(r101, "span");
            return this.f429110a.o(r100, r101, r102, r103);
        }
    }

    static {
        f429100g = new a();
    }

    public RichTextExtraInfo a(RichTextExtraInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "richTextExtraInfo");
        return r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void d() {
    }

    public RichTextElement g(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        return null;
    }

    public String h(Object r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "span");
        Intrinsics.checkNotNullParameter(r101, "sequence");
        return "";
    }

    public boolean o(Spannable r100, Object r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, "span");
        return false;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final com.ss.android.lark.keyboard.edittext2.base.b getTarget() {
        com.ss.android.lark.keyboard.edittext2.base.b r100 = this.f429103c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(PickerReporterConstants.KEY.TARGET);
        return null;
    }

    public d() {
        boolean r100 = true;
        this.f429102b = true;
        this.f429104d = new b(this);
        this.f429105e = new c(this);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
    L8:
        this.f429106f = r100;
        return;
    L5:
        if (KeyboardBaseModule.a().isFeatureGatingEnable("im.messenger.keyboard.trim_richtext_fix_revert") == false) goto L8;
        r100 = false;
        goto L8
    }

    public static RichText j(d r100) {
        r100.getClass();
        return r100.i(0, com.ss.android.lark.keyboard.edittext2.base.c.a.a(r100).length());
    }

    public static void s(Spanned r100) {
        Iterator r101 = ArrayIteratorKt.iterator((p[]) r100.getSpans(0, r100.length(), p.class));
    L4:
        if (r101.hasNext() == false) goto L24;
        p r102 = (p) r101.next();
        Object r103 = r102.f446280b;
        if ((r103 instanceof RichTextElement) == false) goto L8;
        RichTextElement r104 = (RichTextElement) r103;
    L9:
        if (r104 == null) goto L4;
        if (r104.getTag() != RichTextElement.RichTextTag.MARKDOWN) goto L4;
        int r105 = r100.getSpanStart(r102);
        int r106 = r100.getSpanEnd(r102);
        if (r105 < 0) goto L22;
        if (r106 < 0) goto L22;
        if (r105 >= r106) goto L22;
        String r107 = r100.subSequence(r105, r106).toString();
        RichTextElement.MarkdownProperty r108 = (RichTextElement.MarkdownProperty) r104.getProperty();
        if (r108 == null) goto L4;
        r108.setContent(r107);
    L22:
        if ((r100 instanceof Spannable) == false) goto L4;
        ((Spannable) r100).removeSpan(r102);
        goto L4
    L8:
        r104 = null;
        goto L9
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public final void A(com.ss.android.lark.keyboard.edittext2.base.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f429103c = r100;
    }

    @Override // com.ss.android.lark.keyboard.edittext2.base.a
    public void G(com.ss.android.lark.keyboard.edittext2.base.a r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
    }

    public void e(SpannableStringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "ssb");
        if (this.f429106f == true) goto L7;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (this.f429102b == false) goto L7;
        StringsKt.trim(r100);
    L7:
        int r101 = 0;
        z[] r102 = (z[]) r100.getSpans(0, r100.length(), z.class);
        int r103 = r102.length;
    L8:
        if (r101 >= r103) goto L10;
        z r104 = r102[r101];
        r100.replace(r100.getSpanStart(r104), r100.getSpanEnd(r104), "");
        r101 = r101 + 1;
        goto L8
    }

    public RichTextElement f(RichTextElement r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorElement");
        RichTextElement.AnchorProperty r101 = (RichTextElement.AnchorProperty) r100.getProperty();
        if (this.f429101a == false) goto L6;
        Log.i("RichTextGenerator", "isDowngradeAnchor: generate text element");
        return RichTextElementCreator.e(r101.getHref());
    L6:
        return r100;
    }

    public final String n(Spannable r110) {
        Intrinsics.checkNotNullParameter(r110, "targetSequence");
        int r100 = f.f429255a;
        c r101 = this.f429105e;
        Intrinsics.checkNotNullParameter(r110, "content");
        Intrinsics.checkNotNullParameter(r101, "handler");
        ArrayList r102 = new ArrayList();
        r101.e(r110, r102);
        Pair r103 = f.d(r110, r102, r101);
        Map r104 = (Map) r103.component1();
        List r105 = (List) r103.component2();
        if (r102.isEmpty() == true) goto L24;
        StringBuilder r106 = new StringBuilder();
        int r107 = r105.size();
        int r108 = 0;
        int r109 = 0;
    L6:
        if (r109 >= r107) goto L16;
        Pair r111 = f.a(r104, r105, r109);
        if (r111 == null) goto L10;
        SpannableStringBuilder r112 = (SpannableStringBuilder) r110;
        r106.append(r112.subSequence(((Number) r111.getFirst()).intValue(), ((Number) r111.getSecond()).intValue()));
    L10:
        Object r113 = ListProtector.get(r105, r109);
        Pair r114 = (Pair) r104.get(r113);
        if (r114 == null) goto L14;
        SpannableStringBuilder r115 = (SpannableStringBuilder) r110;
        CharSequence r116 = r115.subSequence(((Number) r114.getFirst()).intValue(), ((Number) r114.getSecond()).intValue());
        if (r116 == null) goto L14;
    L15:
        r106.append(r101.g(r113, r116));
        r109 = r109 + 1;
    L14:
        r116 = "";
        goto L15
    L16:
        Pair r117 = (Pair) r104.get(CollectionsKt.lastOrNull(r105));
        if (r117 == null) goto L19;
        r108 = ((Number) r117.getSecond()).intValue();
    L19:
        SpannableStringBuilder r118 = (SpannableStringBuilder) r110;
        r106.append(r118.subSequence(r108, r118.length()).toString());
        return r106.toString();
    L24:
        return r110.toString();
    }

    public final RichTextExtraInfo r(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        RichTextExtraInfo r101 = new RichTextExtraInfo();
        int r102 = 0;
        j[] r103 = (j[]) r100.getSpans(0, r100.length(), j.class);
        Intrinsics.checkNotNull(r103);
        if (r103.length != 0) goto L5;
        boolean r104 = true;
    L7:
        if ((!r104) == false) goto L12;
        int r105 = r103.length;
    L9:
        if (r102 >= r105) goto L12;
        r103[r102].a(r101);
        r102 = r102 + 1;
    L12:
        return a(r101);
    L5:
        r104 = false;
        goto L7
    }

    public final CharSequence t(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (this.f429102b == true) goto L5;
        return r100;
    L5:
        if (this.f429106f == true) goto L7;
        return r100;
    L7:
        return StringsKt.trimEnd(r100);
    }

    public static List b(Spanned r100, p[] r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L15;
        p r105 = r101[r104];
        Object r106 = r105.f446280b;
        boolean r107 = true;
        if ((r106 instanceof RichTextElement) == true) goto L8;
    L12:
        if (r107 == false) goto L14;
        r102.add(r105);
    L14:
        r104 = r104 + 1;
        goto L3
    L8:
        if (((RichTextElement) r106).getTag() != RichTextElement.RichTextTag.TEXT) goto L12;
        String r108 = r100.subSequence(r100.getSpanStart(r105), r100.getSpanEnd(r105)).toString();
        Intrinsics.checkNotNullParameter(r108, "what");
        if (r105.f446282d == false) goto L12;
        r107 = Intrinsics.areEqual(r108, r105.f446281c);
        goto L12
    L15:
        return r102;
    }

    public RichText i(int r100, int r101) {
        Editable r102 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText();
        Log.i("RichTextGenerator", "generateRichText: start, end is (" + r100 + " , " + r101 + ')');
        if (r100 > r101) goto L5;
        int r103 = Math.max(0, r100);
        int r104 = Math.min(r101, r102.length());
        SpannableStringBuilder r105 = e.e(t(r102.subSequence(r103, r104)));
        e(r105);
        if (r105.length() != 0) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == false) goto L14;
        return com.ss.android.lark.widget.richtext.c.a();
    L14:
        if (this.f429106f == false) goto L16;
        RichText r107 = l(r105, 0, r105.length());
    L17:
        Intrinsics.checkNotNull(r102);
        r107.setExtraInfo(r(r102));
        return r107;
    L16:
        r107 = l(r105, r103, r104);
        goto L17
    L9:
        r106 = false;
        goto L10
    L5:
        return com.ss.android.lark.widget.richtext.c.a();
    }

    public final String m(int r100, int r101) {
        Editable r102 = com.ss.android.lark.keyboard.edittext2.base.c.a.a(this).getEditableText();
        Log.i("RichTextGenerator", "generateRichText: start, end is (" + r100 + " , " + r101 + ')');
        if (r100 <= r101) goto L6;
        return "";
    L6:
        SpannableStringBuilder r103 = e.e(t(r102.subSequence(Math.max(0, r100), Math.min(r101, r102.length()))));
        e(r103);
        if (this.f429106f == false) goto L10;
        r103.length();
        return n(r103);
    L10:
        return n(r103);
    }

    public void p(Spanned r100, List<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, "spans");
        s(r100);
        p[] r102 = (p[]) r100.getSpans(0, r100.length(), p.class);
        Intrinsics.checkNotNull(r102);
        ArrayList r103 = (ArrayList) r101;
        r103.addAll(b(r100, r102));
    }

    public void q(Spanned r100, List<Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "editable");
        Intrinsics.checkNotNullParameter(r101, "spans");
        s(r100);
        p[] r102 = (p[]) r100.getSpans(0, r100.length(), p.class);
        Intrinsics.checkNotNull(r102);
        ArrayList r103 = (ArrayList) r101;
        r103.addAll(b(r100, r102));
    }

    public RichText l(Spannable r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "targetSequence");
        int r103 = f.f429255a;
        RichText r104 = com.ss.android.lark.widget.richtext.c.b(f.c(r100, this.f429104d));
        if (this.f429106f == false) goto L5;
        String r105 = n(r100);
    L6:
        r104.setInnerText(r105);
        Intrinsics.checkNotNull(r104);
        return r104;
    L5:
        r105 = m(r101, r102);
        goto L6
    }
}
