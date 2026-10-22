package androidx.compose.material3;

import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DateInputKt$DateInputTextField$5$1", f = "DateInput.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DateInputKt$DateInputTextField$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ Long $initialDateMillis;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ MutableState<TextFieldValue> $text$delegate;
    int label;

    public DateInputKt$DateInputTextField$5$1(Long r1, CalendarModel r2, DateInputFormat r3, Locale r4, MutableState<TextFieldValue> r5, Continuation<? super DateInputKt$DateInputTextField$5$1> r6) {
        this.$initialDateMillis = r1;
        this.$calendarModel = r2;
        this.$dateInputFormat = r3;
        this.$locale = r4;
        this.$text$delegate = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DateInputKt$DateInputTextField$5$1(this.$initialDateMillis, this.$calendarModel, this.$dateInputFormat, this.$locale, this.$text$delegate, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r14);
        Long r15 = this.$initialDateMillis;
        if (r15 == null) goto L15;
        CalendarModel r0 = this.$calendarModel;
        DateInputFormat r1 = this.$dateInputFormat;
        Locale r2 = this.$locale;
        MutableState<TextFieldValue> r3 = this.$text$delegate;
        String r7 = r0.formatWithPattern(r15.longValue(), r1.getPatternWithoutDelimiters(), r2);
        if (r7.length() != 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
        long r5 = TextRange.Companion.getZero-d9O1mEE();
    L13:
        DateInputKt.access$DateInputTextField_xJ3Ic0Y$lambda$7(r3, new TextFieldValue(r7, r5, null, 4, null));
        goto L15
    L12:
        r5 = TextRangeKt.TextRange(r7.length(), r7.length());
        goto L13
    L9:
        r4 = false;
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
