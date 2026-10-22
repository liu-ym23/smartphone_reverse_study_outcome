package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.bmhome.chat.component.bottom.core.m6;
import com.larus.bmhome.chat.referenceicon.ImageViewBitmapLoader;
import com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore;
import com.larus.bmhome.input.api.officemention.OfficeMentionService;
import com.larus.bmhome.utils.x1;
import com.larus.bmhome.view.g4;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: classes25.dex */
public final class ChatInputWithMentionDelegate extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f298615m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EditText f298616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f298617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qp8.a f298618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f298619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f298620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<l0> f298621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<d0> f298622k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g4<l0> f298623l;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f298624a = null;

        static {
            int[] r100 = new int[InputReferenceType.values().length];
            r100[InputReferenceType.CONVERSATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[InputReferenceType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[InputReferenceType.CONTACT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[InputReferenceType.GROUP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[InputReferenceType.DRIVE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f298624a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$setText$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.ChatInputWithMentionDelegate$setText$1", f = "ChatInputWithMentionDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $text;
        int label;
        final /* synthetic */ ChatInputWithMentionDelegate this$0;

        public AnonymousClass1(CharSequence r100, ChatInputWithMentionDelegate r101, Continuation<? super AnonymousClass1> r102) {
            this.$text = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$text, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r100);
            CharSequence r101 = this.$text;
            if ((r101 instanceof Spanned) == false) goto L9;
            ChatInputWithMentionDelegate r102 = this.this$0;
            SpannableStringBuilder r103 = new SpannableStringBuilder(this.$text);
            int r104 = ChatInputWithMentionDelegate.f298615m;
            r101 = r102.i(r103);
            if (r101 != null) goto L9;
            r101 = this.$text.toString();
        L9:
            final ChatInputWithMentionDelegate r105 = this.this$0;
            Function1<? super String, Unit> r106 = new y(r105);
            int r107 = ChatInputWithMentionDelegate.f298615m;
            Editable r108 = r105.l(r101, r106);
            if (r108 == null) goto L12;
            this.this$0.f298616e.setSelection(r108.length());
            return Unit.INSTANCE;
        L12:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean c1() {
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final Object b1() {
        Editable r100 = this.f298616e.getText();
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = i(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        FLogger.f375446a.i("ChatInputWithMentionDelegate", "[prepareContent] contentLength: " + r100.length() + ", transformedLength: " + r101.length());
        return r101;
    }

    public static String f(d0 r100) {
        if (r100.getType() == InputReferenceType.ATTACHMENT) goto L5;
        return null;
    L5:
        String r101 = r100.f298718d;
        if (r101 != null) goto L8;
        return null;
    L8:
        Regex r102 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        com.larus.bmhome.chat.markdown.richtext.r r103 = com.larus.bmhome.chat.markdown.richtext.n.o(r101);
        if ((r103 instanceof com.larus.bmhome.chat.markdown.richtext.r.a) == false) goto L11;
        com.larus.bmhome.chat.markdown.richtext.r.a r104 = (com.larus.bmhome.chat.markdown.richtext.r.a) r103;
    L12:
        if (r104 != null) goto L14;
        return null;
    L14:
        return r104.f307232a;
    L11:
        r104 = null;
        goto L12
    }

    public static String g(d0 r100) {
        if (r100.getType() == InputReferenceType.DRIVE) goto L5;
        return null;
    L5:
        String r101 = r100.f298718d;
        if (r101 != null) goto L8;
    L12:
        i0 r102 = r100.f298720f;
        if (r102 == null) goto L19;
        r101 = r102.f298749d;
        if (r101 == null) goto L19;
        if ((!StringsKt.isBlank(r101)) == false) goto L19;
    L20:
        if (r101 != null) goto L25;
        String r103 = r100.f298715a;
        if ((!StringsKt.isBlank(r103)) == true) goto L27;
        return null;
    L27:
        return r103;
    L25:
        return r101;
    L19:
        r101 = null;
        goto L20
    L8:
        if ((!StringsKt.isBlank(r101)) == true) goto L11;
        r101 = null;
    L11:
        if (r101 != null) goto L25;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void T0(m6 r100) {
        this.f298618g.T0(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void a(boolean r100) {
        this.f298618g.a(r100);
    }

    public final void h(Editable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getSpanStart(this.f298623l) == 0) goto L7;
    L9:
        r100.setSpan(this.f298623l, 0, r100.length(), 18);
        return;
    L7:
        if (r100.getSpanEnd(this.f298623l) != r100.length()) goto L9;
    }

    public final String i(Editable r110) {
        Regex r100 = f0.f298733a;
        Intrinsics.checkNotNullParameter(r110, "editable");
        SpannableStringBuilder r101 = new SpannableStringBuilder(r110);
        int r102 = 0;
        Object[] r103 = r110.getSpans(0, r110.length(), l0.class);
        ArrayList r104 = new ArrayList();
        int r105 = r103.length;
    L3:
        if (r102 >= r105) goto L12;
        l0 r106 = (l0) r103[r102];
        int r107 = r110.getSpanStart(r106);
        int r108 = r110.getSpanEnd(r106);
        if (r107 < 0) goto L8;
        if (r108 <= r107) goto L8;
        Triple r109 = new Triple(Integer.valueOf(r107), Integer.valueOf(r108), r106.f298770a);
    L9:
        if (r109 == null) goto L11;
        r104.add(r109);
    L11:
        r102 = r102 + 1;
    L8:
        r109 = null;
        goto L9
    L12:
        Iterator r111 = CollectionsKt.sortedWith(r104, new h0()).iterator();
    L14:
        if (r111.hasNext() == false) goto L17;
        Triple r112 = (Triple) r111.next();
        r101.replace(((Number) r112.component1()).intValue(), ((Number) r112.component2()).intValue(), f0.h((d0) r112.component3()));
        goto L14
    L17:
        return this.f298618g.b(r101);
    }

    public final d0 m(d0 r100) {
        if (r100.getType() == InputReferenceType.ATTACHMENT) goto L5;
        return r100;
    L5:
        Iterator<T> r101 = this.f298622k.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (k(r100, (d0) r102) == false) goto L7;
    L12:
        d0 r103 = (d0) r102;
        if (r103 != null) goto L15;
        return r100;
    L15:
        String r104 = r100.f298716b;
        String r105 = r103.f298718d;
        if (r105 != null) goto L19;
        r105 = r100.f298718d;
    L19:
        return d0.a(r103, r104, r105, 1013);
    L11:
        r102 = null;
        goto L12
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void r1(x1 r100) {
        if (r100 == null) goto L4;
        x1.d(r100, 1);
        return;
    L4:
        super.r1(r100);
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void setText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        BuildersKt.launch$default(this.f298617f, Dispatchers.getMain().getImmediate(), null, new AnonymousClass1(r100, this, null), 2, null);
    }

    public static boolean k(d0 r100, d0 r101) {
        InputReferenceType r102 = r100.getType();
        InputReferenceType r103 = InputReferenceType.ATTACHMENT;
        if (r102 == r103) goto L5;
    L17:
        return false;
    L5:
        if (r101.getType() != r103) goto L17;
        if ((!StringsKt.isBlank(r100.f298715a)) == true) goto L10;
    L12:
        String r104 = f(r100);
        if (r104 != null) goto L16;
        return false;
    L16:
        return Intrinsics.areEqual(r104, f(r101));
    L10:
        if (Intrinsics.areEqual(r100.f298715a, r101.f298715a) == false) goto L12;
        return true;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final boolean g1(boolean r100, boolean r101) {
        if (r100 == false) goto L7;
        if (r101 == false) goto L7;
        return false;
    L7:
        if (this.f298616e.isFocusable() != r100) goto L10;
        return true;
    L10:
        return false;
    }

    public final Editable l(CharSequence r210, Function1<? super String, Unit> r310) {
        Regex r100 = f0.f298733a;
        Intrinsics.checkNotNullParameter(r210, "content");
        String r101 = r210.toString();
        StringBuilder r102 = new StringBuilder(r101.length());
        ArrayList r103 = new ArrayList();
        List r104 = CollectionsKt.createListBuilder();
        int r105 = 0;
        int r106 = 2;
        Iterator r107 = Regex.findAll$default(f0.f298733a, r101, 0, 2, null).iterator();
    L4:
        if (r107.hasNext() == false) goto L25;
        MatchResult r110 = (MatchResult) r107.next();
        Regex r111 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        com.larus.bmhome.chat.markdown.richtext.i r112 = com.larus.bmhome.chat.markdown.richtext.n.m(r110.getValue(), false, r106);
        IntRange r113 = r110.getRange();
        com.larus.bmhome.chat.markdown.richtext.h r114 = (com.larus.bmhome.chat.markdown.richtext.h) CollectionsKt.singleOrNull(r112.f307210c);
        if (r114 == null) goto L18;
        String r115 = r114.f307203c;
        if (r115 != null) goto L13;
        r115 = r114.f307205e;
        if (r115 == null) goto L18;
    L13:
        String r116 = r115;
        String r108 = StringsKt.trimStart(r112.f307208a, new char[]{'@'});
        if ((true ^ StringsKt.isBlank(r108)) == false) goto L16;
        String r117 = r108;
    L17:
        if (r117 == null) goto L18;
        if (r114.f307205e == null) goto L22;
        InputReferenceType r118 = InputReferenceType.GROUP;
    L23:
        d0 r109 = new d0(r116, r117, r118, null, null, null, r114.f307204d, null, r114.f307206f, r114.f307207g, 184);
    L24:
        r104.add(new f0.a(r113, r109, r112.f307208a));
        r106 = 2;
        goto L4
    L22:
        r118 = InputReferenceType.CONTACT;
        goto L23
    L16:
        r117 = null;
    L18:
        r109 = null;
        goto L24
    L25:
        Iterator r119 = Regex.findAll$default(f0.f298734b, r101, 0, 2, null).iterator();
    L27:
        if (r119.hasNext() == false) goto L50;
        MatchResult r120 = (MatchResult) r119.next();
        Regex r121 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        MatchGroup r122 = r120.getGroups().get(1);
        if (r122 == null) goto L31;
        String r123 = r122.getValue();
    L33:
        if (r123 != null) goto L35;
        r123 = "";
    L35:
        String r124 = com.larus.bmhome.chat.markdown.richtext.n.s(r123);
        MatchGroup r125 = r120.getGroups().get(2);
        if (r125 == null) goto L38;
        String r126 = r125.getValue();
    L39:
        if (r126 != null) goto L41;
        r126 = "";
    L41:
        String r127 = com.larus.bmhome.chat.markdown.richtext.n.r(r126);
        d0 r128 = f0.g(r124, r127);
        if (r128 != null) goto L48;
        if (com.larus.bmhome.chat.markdown.richtext.n.h(r127) == true) goto L46;
        r128 = null;
        goto L48
    L46:
        r128 = new d0(r127, r124, InputReferenceType.DRIVE, r127, null, null, null, null, null, null, 1008);
    L48:
        if (r128 == null) goto L27;
        r104.add(new f0.a(r120.getRange(), r128, ""));
        goto L27
    L38:
        r126 = null;
        goto L39
    L31:
        r123 = null;
        goto L33
    L50:
        Iterator r129 = CollectionsKt.sortedWith(CollectionsKt.build(r104), new g0()).iterator();
    L52:
        if (r129.hasNext() == false) goto L60;
        f0.a r130 = (f0.a) r129.next();
        if (r130.f298735a.getFirst() < r105) goto L52;
        r102.append(r101, r105, r130.f298735a.getFirst());
        d0 r131 = r130.f298736b;
        if (r131 != null) goto L58;
        r102.append(r130.f298737c);
    L59:
        r105 = r130.f298735a.getLast() + 1;
        goto L52
    L58:
        String r132 = "\ufff9input_ref_" + UUID.randomUUID() + 65531;
        r102.append(r132);
        r103.add(new m0(r132, r131));
        goto L59
    L60:
        r102.append(r101, r105, r101.length());
        String r133 = r102.toString();
        Intrinsics.checkNotNullParameter(r133, "content");
        Intrinsics.checkNotNullParameter(r103, "placeholders");
        r310.invoke(r133);
        Editable r134 = this.f298616e.getEditableText();
        if (r134 != null) goto L63;
        return null;
    L63:
        Iterator r135 = r103.iterator();
    L65:
        if (r135.hasNext() == false) goto L69;
        m0 r136 = (m0) r135.next();
        int r137 = StringsKt.indexOf$default(r134, r136.f298772a, 0, false, 6, null);
        if (r137 < 0) goto L65;
        int r138 = r136.f298772a.length() + r137;
        d0 r139 = m(r136.f298773b);
        Regex r140 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        r134.replace(r137, r138, com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r139)));
        e(r134, r139, r137, com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r139)).length() + r137);
        goto L65
    L69:
        return r134;
    }

    public static final Object c(ChatInputWithMentionDelegate r100, com.larus.bmhome.chat.referenceicon.b r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof ChatInputWithMentionDelegate$loadAttachmentIcon$1) == false) goto L7;
        ChatInputWithMentionDelegate$loadAttachmentIcon$1 r103 = (ChatInputWithMentionDelegate$loadAttachmentIcon$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        Iterator r108 = (Iterator) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L31:
        Bitmap r109 = (Bitmap) r105;
        if (r109 != null) goto L37;
    L15:
        Bitmap r110 = null;
        if (r108.hasNext() == false) goto L35;
        String r111 = (String) r108.next();
        r103.L$0 = r108;
        r103.label = 1;
        if (r111 != null) goto L20;
    L28:
        r105 = r110;
    L29:
        if (r105 != r106) goto L31;
        return r106;
    L20:
        if ((!StringsKt.isBlank(r111)) == true) goto L23;
        r111 = null;
    L23:
        if (r111 == null) goto L28;
        r105 = BuildersKt.withContext(Dispatchers.getIO(), new ChatInputWithMentionDelegate$loadDirectIcon$3$1(r111, null), r103);
        if (r105 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        r110 = (Bitmap) r105;
        goto L28
    L36:
        if (r105 != r106) goto L31;
        goto L31
    L35:
        return null;
    L37:
        return r109;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r108 = r101.f308533a.iterator();
    L7:
        r103 = new ChatInputWithMentionDelegate$loadAttachmentIcon$1(r100, r102);
        goto L8
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.inputtext.f, com.larus.bmhome.chat.component.bottom.core.inputtext.p0
    public final void h1(boolean r100, Function0<Boolean> r101, Function0<Unit> r110) {
        Intrinsics.checkNotNullParameter(r101, "needPasteAndSend");
        n0.a(this.f298616e, r100, r101, r110, new ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$1(this), new ChatInputWithMentionDelegate$configCustomCopyAndSendActionMode$2(this));
    }

    public ChatInputWithMentionDelegate(EditText r100, LifecycleCoroutineScope r101, qp8.a r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "inputText");
        Intrinsics.checkNotNullParameter(r101, "coroutineScope");
        Intrinsics.checkNotNullParameter(r102, "mentionEditor");
        super(r100);
        this.f298616e = r100;
        this.f298617f = r101;
        this.f298618g = r102;
        this.f298619h = r103;
        this.f298621j = CollectionsKt.emptyList();
        this.f298622k = CollectionsKt.emptyList();
        this.f298623l = new g4(Reflection.getOrCreateKotlinClass(l0.class));
        x r104 = new x(this);
        h(r100.getEditableText());
        r100.addTextChangedListener(r104);
    }

    public final void e(Editable r210, d0 r211, int r212, int r213) {
        d0 r100 = m(r211);
        r210.setSpan(new l0(r100), r212, r213, 33);
        if (this.f298619h == true) goto L5;
        return;
    L5:
        int r110 = ContextCompat.getColor(this.f298616e.getContext(), v19.c.b(R.attr.larus_primary_50, this.f298616e.getContext(), R.color.larus_primary_50));
        com.larus.bmhome.chat.referenceicon.b r101 = r100.f298722h;
        InputReferenceType r102 = r100.getType();
        int[] r103 = b.f298624a;
        int r104 = r103[r102.ordinal()];
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L9;
        Integer r105 = k0.c(r100.getType());
    L19:
        int r111 = r103[r100.getType().ordinal()];
        if (r111 == 2) goto L31;
        if (r111 == 3) goto L28;
        if (r111 == 4) goto L28;
        if (r111 != 5) goto L35;
        String r112 = g(r100);
        if (r112 == null) goto L35;
        MessageReferenceIconStore r113 = MessageReferenceIconStore.f308518a;
        Intrinsics.checkNotNullParameter(r112, "documentUrl");
        Bitmap r114 = MessageReferenceIconStore.e(MessageReferenceIconStore.b(r112));
    L36:
        if (r114 != null) goto L38;
        Drawable r115 = null;
    L48:
        Drawable r116 = r115;
        if (r115 == null) goto L51;
    L89:
        Drawable r106 = r116;
    L90:
        int r107 = c7.b(18);
        int r117 = c7.b(4);
        if (r100.getType() != InputReferenceType.CONTACT) goto L93;
    L96:
        boolean r118 = true;
    L97:
        if (r114 == null) goto L99;
        boolean r214 = true;
    L100:
        j0 r108 = new j0(r106, r110, r107, r117, r118, r214);
        r210.setSpan(r108, r212, r213, 33);
        if (r106 == null) goto L152;
        MessageReferenceIconStore r109 = MessageReferenceIconStore.f308518a;
        String r119 = MessageReferenceIconStore.a(r100.getType().name(), r100.f298723i, r100.f298724j);
        int r120 = r103[r100.getType().ordinal()];
        if (r120 == 2) goto L143;
        if (r120 == 3) goto L140;
        if (r120 == 4) goto L140;
        if (r120 != 5) goto L153;
        i0 r121 = r100.f298720f;
        String r122 = g(r100);
        if (r122 == null) goto L154;
        if (r121 == null) goto L124;
        Integer r123 = Integer.valueOf(r121.f298747b);
        if (r123.intValue() == 0) goto L117;
        boolean r124 = true;
    L118:
        if (r124 == true) goto L121;
        r123 = null;
    L121:
        if (r123 == null) goto L124;
        Integer r125 = r123;
    L128:
        if (r125 != null) goto L130;
    L138:
        Function1 r126 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$4(r121, this, r100, r122, r125, null);
    L150:
        BuildersKt.launch$default(this.f298617f, null, null, new ChatInputWithMentionDelegate$loadReferenceIcon$1(r126, r100, this, r210, r119, r108, null), 3, null);
        return;
    L130:
        if (r125.intValue() == 0) goto L132;
        boolean r127 = true;
    L133:
        if (r127 == false) goto L135;
        Integer r128 = r125;
    L136:
        if (r128 == null) goto L138;
        MessageReferenceIconStore.j(r122, r128.intValue());
        goto L138
    L135:
        r128 = null;
        goto L136
    L132:
        r127 = false;
        goto L133
    L117:
        r124 = false;
    L124:
        Integer r129 = MessageReferenceIconStore.g(r122);
        if (r129 != null) goto L127;
        r129 = OfficeMentionService.f311790b.m(r122);
    L127:
        r125 = r129;
        goto L128
    L154:
        return;
    L153:
        return;
    L140:
        if (r119 == null) goto L155;
        r126 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$1(this, r100, null);
        goto L150
    L155:
        return;
    L143:
        com.larus.bmhome.chat.referenceicon.b r130 = r100.f298722h;
        if (r130 == null) goto L156;
        String r131 = (String) CollectionsKt.firstOrNull(r130.f308533a);
        if (r131 == null) goto L157;
        r126 = new ChatInputWithMentionDelegate$loadReferenceIcon$loadBitmap$5(r131, this, r130, null);
        goto L150
    L157:
        return;
    L156:
        return;
    L152:
        return;
    L99:
        r214 = false;
        goto L100
    L93:
        if (r100.getType() == InputReferenceType.GROUP) goto L96;
        r118 = false;
        goto L97
    L51:
        if (r100.getType() != InputReferenceType.CONTACT) goto L53;
    L54:
        String r132 = r100.f298723i;
        if (r132 != null) goto L57;
    L60:
        boolean r133 = true;
    L61:
        if (r133 == true) goto L71;
        String r134 = r100.f298724j;
        if (r134 != null) goto L65;
    L68:
        boolean r135 = true;
    L69:
        if (r135 == true) goto L71;
        r116 = new ColorDrawable(0);
        goto L89
    L65:
        if (StringsKt.isBlank(r134) == true) goto L68;
        r135 = false;
    L71:
        InputReferenceType r136 = r100.getType();
        InputReferenceType r137 = InputReferenceType.ATTACHMENT;
        if (r136 != r137) goto L75;
        if (r105 != null) goto L75;
        r116 = new ColorDrawable(0);
    L75:
        if (r105 == null) goto L88;
        Drawable r138 = ContextCompat.getDrawable(this.f298616e.getContext(), r105.intValue());
        if (r138 == null) goto L88;
        Drawable r139 = r138.mutate();
        if (r139 == null) goto L88;
        if (r100.getType() != r137) goto L86;
        if (r101 == null) goto L84;
        Integer r140 = r101.f308534b;
    L85:
        if (r140 == null) goto L86;
    L87:
        r116 = r139;
        goto L89
    L84:
        r140 = null;
    L86:
        r139.setTint(r110);
    L88:
        r106 = null;
        goto L90
    L57:
        if (StringsKt.isBlank(r132) == true) goto L60;
        r133 = false;
        goto L61
    L53:
        if (r100.getType() != InputReferenceType.GROUP) goto L71;
    L38:
        if (r100.getType() != InputReferenceType.ATTACHMENT) goto L41;
        r115 = new com.larus.bmhome.chat.referenceicon.a(r114);
        goto L48
    L41:
        if (r100.getType() != InputReferenceType.CONTACT) goto L43;
    L46:
        RoundedBitmapDrawable r141 = RoundedBitmapDrawableFactory.create(this.f298616e.getResources(), r114);
        r141.setCircular(true);
        Intrinsics.checkNotNull(r141);
        r115 = r141;
        goto L48
    L43:
        if (r100.getType() == InputReferenceType.GROUP) goto L46;
        r115 = new BitmapDrawable(this.f298616e.getResources(), r114);
    L35:
        r114 = null;
    L28:
        MessageReferenceIconStore r142 = MessageReferenceIconStore.f308518a;
        String r143 = MessageReferenceIconStore.a(r100.getType().name(), r100.f298723i, r100.f298724j);
        if (r143 == null) goto L35;
        Intrinsics.checkNotNullParameter(r143, "cacheKey");
        r114 = MessageReferenceIconStore.e(r143);
        goto L36
    L31:
        if (r101 == null) goto L35;
        String r144 = (String) CollectionsKt.firstOrNull(r101.f308533a);
        if (r144 == null) goto L35;
        MessageReferenceIconStore r145 = MessageReferenceIconStore.f308518a;
        Intrinsics.checkNotNullParameter(r144, "source");
        r114 = MessageReferenceIconStore.e("attachment:".concat(r144));
        goto L36
    L9:
        if (r101 == null) goto L12;
        r105 = r101.f308534b;
        if (r105 != null) goto L19;
    L12:
        if (r101 == null) goto L14;
        String r146 = (String) CollectionsKt.firstOrNull(r101.f308533a);
    L15:
        if (r146 != null) goto L17;
        r105 = k0.c(r100.getType());
        goto L19
    L17:
        r105 = null;
        goto L19
    L14:
        r146 = null;
        goto L15
    L18:
        r105 = Integer.valueOf(R.drawable.larus_dbx_ic_squarechat);
        goto L19
    }

    public final boolean j(int r110, int r111, List<d0> r112, boolean r210) {
        int r100 = r110;
        int r101 = r111;
        Intrinsics.checkNotNullParameter(r112, "references");
        if (r112.isEmpty() == true) goto L86;
        List<d0> r102 = r112;
        if ((r102 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L34;
        d0 r104 = (d0) r103.next();
        String r105 = r104.f298721g;
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L30;
        String r107 = r104.f298718d;
        if (r107 != null) goto L23;
    L26:
        boolean r108 = true;
    L27:
        if (r108 == false) goto L30;
        boolean r109 = false;
    L32:
        if ((!r109) == false) goto L11;
        boolean r113 = true;
    L35:
        if (r113 == true) goto L86;
        Editable r114 = this.f298616e.getEditableText();
        if (r114 != null) goto L40;
        return false;
    L40:
        if (r100 < 0) goto L43;
        if (r100 > r101) goto L43;
        boolean r115 = true;
    L44:
        if (r115 == true) goto L46;
    L48:
        String r116 = "";
    L49:
        if (r210 == false) goto L51;
    L56:
        boolean r117 = true;
    L57:
        if (r117 == true) goto L60;
        r100 = RangesKt.coerceAtLeast(this.f298616e.getSelectionStart(), 0);
    L60:
        if (r117 == true) goto L63;
        r101 = RangesKt.coerceAtLeast(this.f298616e.getSelectionEnd(), r100);
    L63:
        String r118 = CollectionsKt.joinToString$default(r102, " ", null, " ", 0, null, new t(), 26, null);
        r114.replace(r100, r101, r118);
        int r119 = r118.length() + r100;
        if (this.f298616e.getEditableText() != r114) goto L86;
        if (r100 >= 0) goto L67;
    L69:
        boolean r120 = false;
    L70:
        if (r120 == false) goto L86;
        if (r100 <= r119) goto L73;
    L75:
        boolean r121 = false;
    L76:
        if (r121 == false) goto L86;
        if (Intrinsics.areEqual(r114.subSequence(r100, r119).toString(), r118) == false) goto L86;
        Iterator<T> r122 = r102.iterator();
        int r123 = r100;
    L82:
        if (r122.hasNext() == false) goto L84;
        d0 r124 = (d0) r122.next();
        r124.getClass();
        Regex r125 = com.larus.bmhome.chat.markdown.richtext.n.f307218a;
        int r126 = com.larus.bmhome.chat.markdown.richtext.n.b(k0.a(r124)).length() + r123;
        e(r114, r124, r123, r126);
        r123 = r126 + 1;
        goto L82
    L84:
        this.f298616e.setSelection(RangesKt.coerceAtMost(r100 + r118.length(), r114.length()));
        return true;
    L73:
        if (r119 > r114.length()) goto L75;
        r121 = true;
        goto L76
    L67:
        if (r100 > r114.length()) goto L69;
        r120 = true;
        goto L70
    L51:
        if (StringsKt.startsWith$default(r116, "@", false, 2, null) == true) goto L56;
        if (StringsKt.startsWith$default(r116, HTTP.URL_DEFAULT, false, 2, null) == true) goto L56;
        r117 = false;
        goto L57
    L46:
        if (r101 > r114.length()) goto L48;
        r116 = r114.subSequence(r100, r101).toString();
    L43:
        r115 = false;
        goto L44
    L23:
        if (StringsKt.isBlank(r107) == true) goto L26;
        r108 = false;
    L30:
        r109 = true;
        goto L32
    L15:
        if (StringsKt.isBlank(r105) == true) goto L18;
        r106 = false;
    L34:
        r113 = false;
        goto L35
    L7:
        if (r102.isEmpty() == false) goto L9;
    L86:
        return false;
    }

    public static final Object d(ChatInputWithMentionDelegate r100, d0 r101, final String r102, final Integer r103, Continuation r104) {
        r100.getClass();
        if (OfficeMentionService.f311790b.isSupported() == true) goto L5;
        return null;
    L5:
        final i0 r105 = r101.f298720f;
        int r106 = ImageViewBitmapLoader.f308513a;
        return ImageViewBitmapLoader.a(r100.f298616e.getContext(), false, new v(r103, r105, r102), r104);
    }
}
