package io.ktor.websocket;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes41.dex */
public final class WebSocketReader implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f492160a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/websocket/WebSocketReader$State;", "", "HEADER", "BODY", ErrorCode.CLOSED, "ktor-websockets"}, k = 1, mv = {1, 8, 0})
    public static final enum State extends Enum<State> {
        public static final State BODY = null;
        public static final State CLOSED = null;
        public static final State HEADER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f492161a = null;

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public static State[] values() {
            return (State[]) f492161a.clone();
        }

        static {
            State r100 = new State("HEADER", 0);
            HEADER = r100;
            State r101 = new State("BODY", 1);
            BODY = r101;
            State r102 = new State(ErrorCode.CLOSED, 2);
            CLOSED = r102;
            f492161a = new State[]{r100, r101, r102};
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f492162a = null;

        static {
            int[] r100 = new int[State.values().length];
            r100[State.HEADER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[State.BODY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[State.CLOSED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f492162a = r100;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return null;
    }

    public final Unit b(ByteBuffer r100, Continuation r101) {
        if ((r101 instanceof WebSocketReader$parseLoop$1) == false) goto L7;
        WebSocketReader$parseLoop$1 r102 = (WebSocketReader$parseLoop$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (ByteBuffer) r102.L$1;
        WebSocketReader r106 = (WebSocketReader) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L18:
        if (r100.hasRemaining() == false) goto L30;
        State r107 = r106.f492160a;
        int r108 = a.f492162a[r107.ordinal()];
        if (r108 == 1) goto L28;
        if (r108 == 2) goto L27;
        if (r108 != 3) goto L18;
        return Unit.INSTANCE;
    L27:
        throw null;
    L28:
        throw null;
    L30:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r104);
        r106 = this;
    L7:
        r102 = new WebSocketReader$parseLoop$1(this, r101);
        goto L8
    }

    public static final Object a(WebSocketReader r100, ByteBuffer r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof WebSocketReader$readLoop$1) == false) goto L7;
        WebSocketReader$readLoop$1 r103 = (WebSocketReader$readLoop$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 != 0) goto L11;
        ResultKt.throwOnFailure(r105);
        r101.clear();
    L26:
        if (r100.f492160a == State.CLOSED) goto L28;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        throw null;
    L28:
        return Unit.INSTANCE;
    L11:
        if (r107 == 1) goto L16;
        if (r107 != 2) goto L15;
        ByteBuffer r108 = (ByteBuffer) r103.L$1;
        WebSocketReader r109 = (WebSocketReader) r103.L$0;
        ResultKt.throwOnFailure(r105);
        r101 = r108;
        r100 = r109;
    L23:
        r101.compact();
        goto L26
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r101 = (ByteBuffer) r103.L$1;
        WebSocketReader r110 = (WebSocketReader) r103.L$0;
        ResultKt.throwOnFailure(r105);
        if (((Number) r105).intValue() != (-1)) goto L19;
        r110.f492160a = State.CLOSED;
        goto L28
    L19:
        r101.flip();
        r103.L$0 = r110;
        r103.L$1 = r101;
        r103.label = 2;
        if (r110.b(r101, r103) == r106) goto L31;
        r100 = r110;
        goto L23
    L31:
        return r106;
    L7:
        r103 = new WebSocketReader$readLoop$1(r100, r102);
        goto L8
    }
}
