package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.tencent.open.SocialConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\t\u0010\u0000\u001a\u00020\u0001H\u0087\b\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\b\u001a3\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\tH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001a2\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u000f\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\u0011\u001a\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0013\u001a<\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aA\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aB\u0010\u0016\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b*\u0002H\u00102\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001aG\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u000b*\u0002H\u00102\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u000b0\t¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u0017\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u001a>\u0010\u001a\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\u0002H\u00102\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00190\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {AlarmSessionType.TODO, "", "reason", "", SalesInfoStruct.REPEAT, "", "times", "", "action", "Lkotlin/Function1;", "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "with", ExifInterface.GPS_DIRECTION_TRUE, SocialConstants.PARAM_RECEIVER, "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "also", e1.REPLY_ACTION_APPLY, "let", "takeIf", "predicate", "", "takeUnless", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/StandardKt")
class StandardKt__StandardKt {
    public StandardKt__StandardKt() {
    }

    private static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    private static final Void TODO(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        throw new NotImplementedError("An operation is not implemented: " + r100);
    }

    private static final <R> R run(Function0<? extends R> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        return r100.invoke();
    }

    private static final <T> T also(T r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke(r100);
        return r100;
    }

    private static final <T> T apply(T r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        r101.invoke(r100);
        return r100;
    }

    private static final <T, R> R let(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return r101.invoke(r100);
    }

    private static final void repeat(int r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101.invoke(Integer.valueOf(r102));
        r102 = r102 + 1;
        goto L3
    }

    private static final <T, R> R run(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return r101.invoke(r100);
    }

    private static final <T> T takeIf(T r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if (r101.invoke(r100).booleanValue() == true) goto L7;
        return null;
    L7:
        return r100;
    }

    private static final <T> T takeUnless(T r100, Function1<? super T, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if (r101.invoke(r100).booleanValue() == false) goto L7;
        return null;
    L7:
        return r100;
    }

    private static final <T, R> R with(T r100, Function1<? super T, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return r101.invoke(r100);
    }
}
