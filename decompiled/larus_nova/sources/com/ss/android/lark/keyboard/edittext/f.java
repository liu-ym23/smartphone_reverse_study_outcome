package com.ss.android.lark.keyboard.edittext;

import com.ss.android.lark.widget.richtext.RichText;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<String, Continuation<? super RichText>, Object> f428943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<RichText, Continuation<? super String>, Object> f428944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<RichText> f428945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<RichText, Unit> f428946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<RichText, Unit> f428947e;

    public final Object a(Continuation r100) {
        if ((r100 instanceof MarkdownInputContentDelegate$appendMarkdownContent$1) == false) goto L7;
        MarkdownInputContentDelegate$appendMarkdownContent$1 r101 = (MarkdownInputContentDelegate$appendMarkdownContent$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        RichText r106 = (RichText) r103;
        if (r106 == null) goto L20;
        this.f428947e.invoke(r106);
        return Boxing.boxBoolean(true);
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Function2<String, Continuation<? super RichText>, Object> r107 = this.f428943a;
        r101.label = 1;
        r103 = r107.invoke(null, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MarkdownInputContentDelegate$appendMarkdownContent$1(this, r100);
        goto L8
    }

    public final Object b(Continuation r100) {
        if ((r100 instanceof MarkdownInputContentDelegate$setMarkdownContent$1) == false) goto L7;
        MarkdownInputContentDelegate$setMarkdownContent$1 r101 = (MarkdownInputContentDelegate$setMarkdownContent$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        RichText r106 = (RichText) r103;
        if (r106 == null) goto L20;
        this.f428946d.invoke(r106);
        return Boxing.boxBoolean(true);
    L20:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Function2<String, Continuation<? super RichText>, Object> r107 = this.f428943a;
        r101.label = 1;
        r103 = r107.invoke(null, r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new MarkdownInputContentDelegate$setMarkdownContent$1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Function2<? super String, ? super Continuation<? super RichText>, ? extends Object> r100, Function2<? super RichText, ? super Continuation<? super String>, ? extends Object> r101, Function0<? extends RichText> r102, Function1<? super RichText, Unit> r103, Function1<? super RichText, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "markdownToRichText");
        Intrinsics.checkNotNullParameter(r101, "richTextToMarkdown");
        Intrinsics.checkNotNullParameter(r102, "getCurrentRichText");
        Intrinsics.checkNotNullParameter(r103, "replaceRichText");
        Intrinsics.checkNotNullParameter(r104, "appendRichText");
        this.f428943a = r100;
        this.f428944b = r101;
        this.f428945c = r102;
        this.f428946d = r103;
        this.f428947e = r104;
    }
}
