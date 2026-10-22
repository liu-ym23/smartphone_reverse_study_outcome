package xs4;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.homepage.l0;
import com.bytedance.ee.bear.bitable.homepage.workspace.WorkspaceSearchPanelType;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.ee.bear.workspace.NewBaseEntry;
import com.bytedance.ee.bear.workspace.NewBaseType;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.lark.lark_bitable_android.BufferCallStatus;
import com.bytedance.lark.lark_bitable_android.HomepageAction;
import com.bytedance.lark.lark_bitable_android.HomepageListType;
import com.bytedance.lark.lark_bitable_android.NativeLib;
import com.bytedance.lark.lark_bitable_android.RustBuffer;
import com.bytedance.lark.lark_bitable_android.UnhandledException;
import com.bytedance.lark.lark_bitable_android.WorkspaceBitableMoveStatus;
import com.bytedance.lark.lark_bitable_android.b0;
import com.bytedance.lark.lark_bitable_android.i0;
import com.bytedance.lark.lark_bitable_android.j;
import com.bytedance.lark.lark_bitable_android.j0;
import com.bytedance.lark.lark_bitable_android.k0;
import com.bytedance.lark.lark_bitable_android.l;
import com.bytedance.lark.lark_bitable_android.m;
import com.bytedance.lark.lark_bitable_android.m0;
import com.bytedance.lark.lark_bitable_android.n;
import com.bytedance.lark.lark_bitable_android.o;
import com.bytedance.lark.lark_bitable_android.o0;
import com.bytedance.lark.lark_bitable_android.p;
import com.bytedance.lark.lark_bitable_android.q;
import com.bytedance.lark.lark_bitable_android.r;
import com.bytedance.lark.lark_bitable_android.s;
import com.bytedance.lark.lark_bitable_android.x;
import com.bytedance.lark.lark_bitable_android.z;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.sun.jna.Pointer;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.UStringsKt;
import lark_bitable.proto.FuncParamsX2a53b6de2ddfdaa7;
import lark_bitable.proto.FuncParamsX594b8f99fc9a5d01;
import lark_bitable.proto.FuncParamsX827f4aec43bb21c9;
import lark_bitable.proto.FuncParamsXb974c3e45c31adc5;
import lark_bitable.proto.MoltenFfiInstanceMsg;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements er5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f564978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f564979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, j> f564980c;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f564981a = null;

        static {
            int[] r100 = new int[WorkspaceAction.values().length];
            r100[WorkspaceAction.MoveIn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[WorkspaceAction.MoveBetween.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[WorkspaceAction.NewTo.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f564981a = r100;
        }
    }

    /* JADX INFO: renamed from: xs4.c$c, reason: collision with other inner class name */
    public static final class C8268c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WorkspaceAction f564982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f564983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f564984c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f564985d;

        /* JADX INFO: renamed from: xs4.c$c$a */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f564986a = null;

            static {
                int[] r100 = new int[WorkspaceAction.values().length];
                r100[WorkspaceAction.MoveIn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[WorkspaceAction.MoveOut.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[WorkspaceAction.MoveBetween.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f564986a = r100;
            }
        }

        @Override // com.bytedance.lark.lark_bitable_android.p
        public final void a(j r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "data_");
            Intrinsics.checkNotNullParameter(r102, "msg");
            String r103 = r100.f253076d;
            WorkspaceAction r104 = this.f564982a;
            int r105 = a.f564986a[r104.ordinal()];
            boolean r106 = true;
            if (r105 != 1) goto L5;
            r106 = r100.f253075c;
        L16:
            if (r106 == false) goto L22;
            if (r103 != null) goto L19;
            this.f564983b.f564980c.remove(this.f564984c);
        L20:
            this.f564985d.invoke(r103);
            return;
        L19:
            this.f564983b.f564980c.put(this.f564984c, r100);
            goto L20
        L22:
            return;
        L5:
            if (r105 != 2) goto L7;
            r106 = r100.f253074b;
            goto L16
        L7:
            if (r105 != 3) goto L16;
            if (r103 != null) goto L11;
        L13:
            r106 = false;
            goto L16
        L11:
            if (r100.f253073a == false) goto L13;
            goto L13
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C8268c(WorkspaceAction r100, c r101, String r102, Function1<? super String, Unit> r103) {
            this.f564982a = r100;
            this.f564983b = r101;
            this.f564984c = r102;
            this.f564985d = r103;
        }
    }

    public static final class d<T> implements FlowableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f564987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ er5.a f564988b;

        public static final class a implements er5.f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowableEmitter<DocumentCreateInfo> f564989a;

            public a(FlowableEmitter<DocumentCreateInfo> r100) {
                this.f564989a = r100;
            }

            @Override // er5.f
            public final void a(NetService.ServerErrorException r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f564989a.onError(r100);
            }

            @Override // er5.f
            public final void onSuccess(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "url");
                Intrinsics.checkNotNullParameter(r101, "token");
                DocumentCreateInfo r102 = new DocumentCreateInfo();
                r102.f216950d = r100;
                r102.f216948b = r101;
                r102.f216952f = 8;
                this.f564989a.onNext(r102);
                this.f564989a.onComplete();
            }
        }

        public d(c r100, er5.a r101) {
            this.f564987a = r100;
            this.f564988b = r101;
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public final void subscribe(FlowableEmitter<DocumentCreateInfo> r110) {
            Intrinsics.checkNotNullParameter(r110, "it");
            c r100 = this.f564987a;
            er5.a r101 = this.f564988b;
            a r102 = new a(r110);
            r100.getClass();
            LinkedHashMap r111 = new LinkedHashMap();
            if (r101.f473592b == false) goto L5;
            r111.put("need_new_workspace", "1");
        L5:
            String r103 = r101.f473593c;
            if (r103 == null) goto L8;
            r111.put("template_token", r103);
        L8:
            String r104 = r101.f473594d;
            if (r104 == null) goto L11;
            r111.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r104);
        L11:
            String r105 = r101.f473595e;
            if (r105 == null) goto L14;
            r111.put("title", r105);
        L14:
            String r106 = r101.f473596f;
            if (r106 == null) goto L17;
            r111.put("workspace_title", r106);
        L17:
            Integer r107 = r101.f473597g;
            if (r107 == null) goto L20;
            r111.put("source", String.valueOf(r107.intValue()));
        L20:
            z r108 = r100.l();
            String r109 = r101.f473591a;
            xs4.d r112 = new xs4.d(r102);
            Intrinsics.checkNotNullParameter(r111, "params");
            Intrinsics.checkNotNullParameter(r112, "callback");
        L21:
            long r113 = r108.f253121c.get();
            if (r113 == 0) goto L69;
            if (r113 == Long.MAX_VALUE) goto L67;
            if (r108.f253121c.compareAndSet(r113, 1 + r113) == false) goto L21;
            Pointer r114 = r108.f253119a;     // Catch: Throwable -> L61
            s r115 = s.f253114a;     // Catch: Throwable -> L61
            NativeLib.Companion r116 = NativeLib.Companion;     // Catch: Throwable -> L61
            m0 r117 = new m0(Long.valueOf(Pointer.nativeValue(r114)), "requestCreateBitable");     // Catch: Throwable -> L61
            r116.getClass();     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r117, "info");     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r112, "<this>");     // Catch: Throwable -> L61
            int r118 = b0.f252987b;     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r112, "callback");     // Catch: Throwable -> L61
            MoltenFfiInstanceMsg r119 = new MoltenFfiInstanceMsg(-7489622961066636058L, Long.valueOf(r.f253103a.a(new b0(r112))));     // Catch: Throwable -> L61
            String r120 = null;
            FuncParamsX827f4aec43bb21c9 r121 = new FuncParamsX827f4aec43bb21c9(r109, r111, r119, null);     // Catch: Throwable -> L61
            int r122 = FuncParamsX827f4aec43bb21c9.ADAPTER.encodedSize(r121);     // Catch: Throwable -> L61
            if (r122 <= 0) goto L30;
            RustBuffer.Companion.getClass();     // Catch: Throwable -> L61
            RustBuffer.ByValue r123 = RustBuffer.a.a(r122);     // Catch: Throwable -> L61
            Pointer r124 = r123.data;     // Catch: Throwable -> L61
            Intrinsics.checkNotNull(r124);     // Catch: Throwable -> L61
            o0 r125 = new o0(r124);     // Catch: Throwable -> L61
            r121.encode(r125);     // Catch: Throwable -> L61
            r125.close();     // Catch: Throwable -> L61
        L31:
            BufferCallStatus.ByValue r126 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r114, 3573049917271791909L, r123);     // Catch: Throwable -> L61
            int r127 = r126.code;     // Catch: Throwable -> L61
            if (r127 != 0) goto L38;
            if (r108.f253121c.decrementAndGet() != 0) goto L76;
            r108.b();
            return;
        L76:
            return;
        L38:
            if (r127 == 1) goto L60;
            if (r127 != 2) goto L57;
            RustBuffer.ByValue r128 = r126.data;     // Catch: Throwable -> L61
            int r129 = r128.len;     // Catch: Throwable -> L61
            if (r129 > 0) goto L71;
            UnhandledException r130 = new UnhandledException("Rust panic");     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r130, "e");     // Catch: Throwable -> L61
            throw r130;     // Catch: Throwable -> L61
        L71:
            Pointer r131 = r128.data;     // Catch: Throwable -> L52
            if (r131 == null) goto L46;
            byte[] r132 = r131.getByteArray(0, r129);     // Catch: Throwable -> L52
        L47:
            if (r132 == null) goto L49;
            r120 = new String(r132, Charsets.UTF_8);     // Catch: Throwable -> L52
        L49:
            Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L52
            RustBuffer.a r133 = RustBuffer.Companion;     // Catch: Throwable -> L61
            RustBuffer.ByValue r134 = r126.data;     // Catch: Throwable -> L61
            r133.getClass();     // Catch: Throwable -> L61
            RustBuffer.a.c(r134);     // Catch: Throwable -> L61
            UnhandledException r135 = new UnhandledException(r120);     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r135, "e");     // Catch: Throwable -> L61
            throw r135;     // Catch: Throwable -> L61
        L46:
            r132 = null;
        L52:
            th = move-exception;
            RustBuffer.a r136 = RustBuffer.Companion;     // Catch: Throwable -> L61
            RustBuffer.ByValue r137 = r126.data;     // Catch: Throwable -> L61
            r136.getClass();     // Catch: Throwable -> L61
            RustBuffer.a.c(r137);     // Catch: Throwable -> L61
            throw th;     // Catch: Throwable -> L61
        L57:
            UnhandledException r138 = new UnhandledException("Unknown rust call status: " + r126 + ".code");     // Catch: Throwable -> L61
            Intrinsics.checkNotNullParameter(r138, "e");     // Catch: Throwable -> L61
            throw r138;     // Catch: Throwable -> L61
        L60:
            throw ((Throwable) r115.a(r126.data));     // Catch: Throwable -> L61
        L30:
            RustBuffer.Companion.getClass();     // Catch: Throwable -> L61
            r123 = RustBuffer.a.a(0);     // Catch: Throwable -> L61
        L61:
            th = move-exception;
            if (r108.f253121c.decrementAndGet() != 0) goto L65;
            r108.b();
        L65:
            throw th;
        L67:
            throw new IllegalStateException(z.class.getSimpleName().concat(" call counter would overflow"));
        L69:
            throw new IllegalStateException(z.class.getSimpleName().concat(" object has already been destroyed"));
        }
    }

    public static final class e implements x {
        public e() {
        }

        @Override // com.bytedance.lark.lark_bitable_android.x
        public final void a(HomepageAction r100, String r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r103, "msg");
        }

        @Override // com.bytedance.lark.lark_bitable_android.x
        public final void b(HomepageListType r100, HomepageAction r101, i0 r102) {
            Intrinsics.checkNotNullParameter(r100, "listType");
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r102, "data_");
        }

        @Override // com.bytedance.lark.lark_bitable_android.x
        public final void d(HomepageAction r100, String r101, Map<String, String> r102) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "token");
            Intrinsics.checkNotNullParameter(r102, "ext");
        }

        @Override // com.bytedance.lark.lark_bitable_android.x
        public final void e(HomepageListType r100, HomepageAction r101, long r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "listType");
            Intrinsics.checkNotNullParameter(r101, "action");
            Intrinsics.checkNotNullParameter(r103, "msg");
        }
    }

    public static final class f implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f564990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<er5.h, Unit> f564991b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(c r100, Function1<? super er5.h, Unit> r101) {
            this.f564990a = r100;
            this.f564991b = r101;
        }

        @Override // com.bytedance.lark.lark_bitable_android.l
        public final void a(n r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "msg");
            tt5.a.b("WorkspaceServiceImpl", "onBitableTenantType: " + r100 + ' ' + r101 + ' ' + r102);
            if (r101 != 0) goto L15;
            if (r100 == null) goto L15;
            c r103 = this.f564990a;
            if (r103.f564979b != null) goto L9;
            r103.f564979b = Boolean.valueOf(r100.f253090a);
        L9:
            Function1<er5.h, Unit> r104 = this.f564991b;
            Boolean r105 = this.f564990a.f564979b;
            if (r105 == null) goto L12;
            boolean r106 = r105.booleanValue();
        L13:
            r104.invoke(new er5.h(r106, r100.f253091b));
            return;
        L12:
            r106 = false;
        L15:
            tt5.a.k("WorkspaceServiceImpl", "getTenantInfo failed, errorCode=" + r101 + ", msg=" + r102);
        }
    }

    public static final class g implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f564992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f564993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f564994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f564995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f564996e;

        public static final class a implements j0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f564997a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f564998b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f564999c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f565000d;

            @Override // com.bytedance.lark.lark_bitable_android.j0
            public final void a(o r100, long r101, String r102) {
                Intrinsics.checkNotNullParameter(r102, "msg");
                if (r101 != 0) goto L10;
                if (r100 == null) goto L6;
                WorkspaceBitableMoveStatus r103 = r100.f253097c;
            L8:
                if (r103 != WorkspaceBitableMoveStatus.Success) goto L10;
                this.f564997a.invoke();
                Toast.showSuccessText(this.f564998b, R.string.Bitable_BaseWorkspace_Home_RemoveSuccessful_Toast);
                this.f564999c.f564980c.remove(this.f565000d);
                return;
            L6:
                r103 = null;
            L10:
                Toast.showFailureText(this.f564998b, R.string.Bitable_BaseWorkspace_RemoveFailed_Toast);
            }

            public a(Function0<Unit> r100, Context r101, c r102, String r103) {
                this.f564997a = r100;
                this.f564998b = r101;
                this.f564999c = r102;
                this.f565000d = r103;
            }
        }

        public g(j r100, Context r101, c r102, String r103, Function0<Unit> r104) {
            this.f564992a = r100;
            this.f564993b = r101;
            this.f564994c = r102;
            this.f564995d = r103;
            this.f564996e = r104;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r110, int r210) {
            j r100 = this.f564992a;
            if (r100 == null) goto L55;
            String r101 = r100.f253076d;
            if (r101 == null) goto L62;
            Context r102 = this.f564993b;
            c r103 = this.f564994c;
            String r104 = this.f564995d;
            Function0<Unit> r105 = this.f564996e;
            Toast.showLoading(r102, r102.getString(R.string.Bitable_BaseWorkspace_RemovingFromWorkspace_Toast_Mob));
            z r106 = r103.l();
            a r107 = new a(r105, r102, r103, r104);
            Intrinsics.checkNotNullParameter(r101, "spaceToken");
            Intrinsics.checkNotNullParameter(r104, "docToken");
            Intrinsics.checkNotNullParameter(r107, "callback");
        L7:
            long r108 = r106.f253121c.get();
            if (r108 == 0) goto L54;
            if (r108 == Long.MAX_VALUE) goto L52;
            if (r106.f253121c.compareAndSet(r108, 1 + r108) == false) goto L7;
            Pointer r111 = r106.f253119a;     // Catch: Throwable -> L46
            s r109 = s.f253114a;     // Catch: Throwable -> L46
            NativeLib.Companion r112 = NativeLib.Companion;     // Catch: Throwable -> L46
            m0 r113 = new m0(Long.valueOf(Pointer.nativeValue(r111)), "moveBitableOutWorkspace");     // Catch: Throwable -> L46
            r112.getClass();     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r113, "info");     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r107, "<this>");     // Catch: Throwable -> L46
            int r114 = k0.f253078b;     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r107, "callback");     // Catch: Throwable -> L46
            MoltenFfiInstanceMsg r115 = new MoltenFfiInstanceMsg(-5924464591858506509L, Long.valueOf(r.f253103a.a(new k0(r107))));     // Catch: Throwable -> L46
            String r116 = null;
            FuncParamsX594b8f99fc9a5d01 r117 = new FuncParamsX594b8f99fc9a5d01(r101, r104, r115, null);     // Catch: Throwable -> L46
            int r118 = FuncParamsX594b8f99fc9a5d01.ADAPTER.encodedSize(r117);     // Catch: Throwable -> L46
            if (r118 <= 0) goto L16;
            RustBuffer.Companion.getClass();     // Catch: Throwable -> L46
            RustBuffer.ByValue r119 = RustBuffer.a.a(r118);     // Catch: Throwable -> L46
            Pointer r120 = r119.data;     // Catch: Throwable -> L46
            Intrinsics.checkNotNull(r120);     // Catch: Throwable -> L46
            o0 r121 = new o0(r120);     // Catch: Throwable -> L46
            r117.encode(r121);     // Catch: Throwable -> L46
            r121.close();     // Catch: Throwable -> L46
        L17:
            BufferCallStatus.ByValue r122 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r111, -871909441598480988L, r119);     // Catch: Throwable -> L46
            int r123 = r122.code;     // Catch: Throwable -> L46
            if (r123 != 0) goto L23;
            if (r106.f253121c.decrementAndGet() != 0) goto L63;
            r106.b();
            return;
        L63:
            return;
        L23:
            if (r123 == 1) goto L45;
            if (r123 != 2) goto L42;
            RustBuffer.ByValue r124 = r122.data;     // Catch: Throwable -> L46
            int r125 = r124.len;     // Catch: Throwable -> L46
            if (r125 > 0) goto L57;
            UnhandledException r126 = new UnhandledException("Rust panic");     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r126, "e");     // Catch: Throwable -> L46
            throw r126;     // Catch: Throwable -> L46
        L57:
            Pointer r127 = r124.data;     // Catch: Throwable -> L37
            if (r127 == null) goto L31;
            byte[] r128 = r127.getByteArray(0, r125);     // Catch: Throwable -> L37
        L32:
            if (r128 == null) goto L34;
            r116 = new String(r128, Charsets.UTF_8);     // Catch: Throwable -> L37
        L34:
            Intrinsics.checkNotNull(r116);     // Catch: Throwable -> L37
            RustBuffer.a r129 = RustBuffer.Companion;     // Catch: Throwable -> L46
            RustBuffer.ByValue r130 = r122.data;     // Catch: Throwable -> L46
            r129.getClass();     // Catch: Throwable -> L46
            RustBuffer.a.c(r130);     // Catch: Throwable -> L46
            UnhandledException r131 = new UnhandledException(r116);     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r131, "e");     // Catch: Throwable -> L46
            throw r131;     // Catch: Throwable -> L46
        L31:
            r128 = null;
        L37:
            th = move-exception;
            RustBuffer.a r132 = RustBuffer.Companion;     // Catch: Throwable -> L46
            RustBuffer.ByValue r133 = r122.data;     // Catch: Throwable -> L46
            r132.getClass();     // Catch: Throwable -> L46
            RustBuffer.a.c(r133);     // Catch: Throwable -> L46
            throw th;     // Catch: Throwable -> L46
        L42:
            UnhandledException r134 = new UnhandledException("Unknown rust call status: " + r122 + ".code");     // Catch: Throwable -> L46
            Intrinsics.checkNotNullParameter(r134, "e");     // Catch: Throwable -> L46
            throw r134;     // Catch: Throwable -> L46
        L45:
            throw ((Throwable) r109.a(r122.data));     // Catch: Throwable -> L46
        L16:
            RustBuffer.Companion.getClass();     // Catch: Throwable -> L46
            r119 = RustBuffer.a.a(0);     // Catch: Throwable -> L46
        L46:
            th = move-exception;
            if (r106.f253121c.decrementAndGet() != 0) goto L50;
            r106.b();
        L50:
            throw th;
        L52:
            throw new IllegalStateException(z.class.getSimpleName().concat(" call counter would overflow"));
        L54:
            throw new IllegalStateException(z.class.getSimpleName().concat(" object has already been destroyed"));
        L62:
            return;
        }
    }

    public static final class h implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f565001a = null;

        static {
            f565001a = new h();
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
        }
    }

    static {
    }

    @Override // er5.b
    public final void i() {
    }

    @Override // er5.b
    public final boolean j() {
        int r100 = com.bytedance.ee.bear.bitable.c.f207079a;
        return com.bytedance.ee.bear.bitable.core.usercomponent.b.c("bitable.homepage.workspace.enable");
    }

    public final z l() {
        z r100 = this.f564978a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        z r101 = new z(UStringsKt.toULong(com.bytedance.ee.bear.contract.a.a().docDynamicConfig().f216922f.f216928a), new e());
        this.f564978a = r101;
        return r101;
    }

    public c() {
        this.f564980c = new LinkedHashMap();
    }

    @Override // er5.b
    public final void a(Map r100) {
        xs4.a.a("ccm_base_homepage_more_click_menu_click", r100);
    }

    @Override // er5.b
    public final String g(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        l0 r101 = (l0) r100.getParentFragment();
        if (r101 == null) goto L6;
        String r102 = r101.Sv();
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // er5.b
    public final Flowable<DocumentCreateInfo> k(er5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "creationParams");
        return Flowable.create(new d(this, r100), BackpressureStrategy.BUFFER);
    }

    @Override // er5.b
    public final void d(String r210, Function1<? super er5.h, Unit> r211) {
        Intrinsics.checkNotNullParameter(r210, "docToken");
        Intrinsics.checkNotNullParameter(r211, "callback");
        z r100 = l();
        if (this.f564979b != null) goto L5;
        boolean r101 = true;
    L6:
        f r102 = new f(this, r211);
        Intrinsics.checkNotNullParameter(r210, "docToken");
        Intrinsics.checkNotNullParameter(r102, "callback");
    L7:
        long r103 = r100.f253121c.get();
        if (r103 == 0) goto L54;
        if (r103 == Long.MAX_VALUE) goto L52;
        if (r100.f253121c.compareAndSet(r103, 1 + r103) == false) goto L7;
        Pointer r110 = r100.f253119a;     // Catch: Throwable -> L46
        s r111 = s.f253114a;     // Catch: Throwable -> L46
        NativeLib.Companion r104 = NativeLib.Companion;     // Catch: Throwable -> L46
        m0 r105 = new m0(Long.valueOf(Pointer.nativeValue(r110)), "requestBitableTenantType");     // Catch: Throwable -> L46
        r104.getClass();     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r105, "info");     // Catch: Throwable -> L46
        Boolean r106 = Boolean.valueOf(r101);     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r102, "<this>");     // Catch: Throwable -> L46
        int r107 = m.f253083b;     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r102, "callback");     // Catch: Throwable -> L46
        FuncParamsX2a53b6de2ddfdaa7 r112 = new FuncParamsX2a53b6de2ddfdaa7(r210, 8, r106, new MoltenFfiInstanceMsg(-8408463455633569163L, Long.valueOf(r.f253103a.a(new m(r102)))), null);     // Catch: Throwable -> L46
        int r108 = FuncParamsX2a53b6de2ddfdaa7.ADAPTER.encodedSize(r112);     // Catch: Throwable -> L46
        if (r108 <= 0) goto L16;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L46
        RustBuffer.ByValue r109 = RustBuffer.a.a(r108);     // Catch: Throwable -> L46
        Pointer r113 = r109.data;     // Catch: Throwable -> L46
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L46
        o0 r114 = new o0(r113);     // Catch: Throwable -> L46
        r112.encode(r114);     // Catch: Throwable -> L46
        r114.close();     // Catch: Throwable -> L46
    L17:
        BufferCallStatus.ByValue r115 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r110, 1538350860099681439L, r109);     // Catch: Throwable -> L46
        int r116 = r115.code;     // Catch: Throwable -> L46
        if (r116 == 0) goto L20;
        if (r116 == 1) goto L45;
        if (r116 != 2) goto L42;
        RustBuffer.ByValue r117 = r115.data;     // Catch: Throwable -> L46
        int r118 = r117.len;     // Catch: Throwable -> L46
        if (r118 > 0) goto L56;
        UnhandledException r119 = new UnhandledException("Rust panic");     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r119, "e");     // Catch: Throwable -> L46
        throw r119;     // Catch: Throwable -> L46
    L56:
        Pointer r120 = r117.data;     // Catch: Throwable -> L37
        String r121 = null;
        if (r120 == null) goto L31;
        byte[] r122 = r120.getByteArray(0, r118);     // Catch: Throwable -> L37
    L32:
        if (r122 == null) goto L34;
        r121 = new String(r122, Charsets.UTF_8);     // Catch: Throwable -> L37
    L34:
        Intrinsics.checkNotNull(r121);     // Catch: Throwable -> L37
        RustBuffer.a r123 = RustBuffer.Companion;     // Catch: Throwable -> L46
        RustBuffer.ByValue r124 = r115.data;     // Catch: Throwable -> L46
        r123.getClass();     // Catch: Throwable -> L46
        RustBuffer.a.c(r124);     // Catch: Throwable -> L46
        UnhandledException r125 = new UnhandledException(r121);     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r125, "e");     // Catch: Throwable -> L46
        throw r125;     // Catch: Throwable -> L46
    L31:
        r122 = null;
    L37:
        th = move-exception;
        RustBuffer.a r126 = RustBuffer.Companion;     // Catch: Throwable -> L46
        RustBuffer.ByValue r127 = r115.data;     // Catch: Throwable -> L46
        r126.getClass();     // Catch: Throwable -> L46
        RustBuffer.a.c(r127);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L42:
        UnhandledException r128 = new UnhandledException("Unknown rust call status: " + r115 + ".code");     // Catch: Throwable -> L46
        Intrinsics.checkNotNullParameter(r128, "e");     // Catch: Throwable -> L46
        throw r128;     // Catch: Throwable -> L46
    L45:
        throw ((Throwable) r111.a(r115.data));     // Catch: Throwable -> L46
    L20:
        if (r100.f253121c.decrementAndGet() != 0) goto L61;
        r100.b();
        return;
    L61:
        return;
    L16:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L46
        r109 = RustBuffer.a.a(0);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        if (r100.f253121c.decrementAndGet() != 0) goto L50;
        r100.b();
    L50:
        throw th;
    L52:
        throw new IllegalStateException(z.class.getSimpleName().concat(" call counter would overflow"));
    L54:
        throw new IllegalStateException(z.class.getSimpleName().concat(" object has already been destroyed"));
    L5:
        r101 = false;
        goto L6
    }

    @Override // er5.b
    public final void b(Context r100, String r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "docToken");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        WorkspaceAction r101 = WorkspaceAction.MoveBetween;
        if ((232 & 4) == 0) goto L5;
        String r102 = null;
    L6:
        e(r100, r101, r102, null, null, null);
        return;
    L5:
        r102 = r110;
        goto L6
    }

    @Override // er5.b
    public final void c(WorkspaceAction r110, String r111, Function1<? super String, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r112, "onSuccess");
        z r100 = l();
        C8268c r101 = new C8268c(r110, this, r111, r112);
        Intrinsics.checkNotNullParameter(r111, "docToken");
        Intrinsics.checkNotNullParameter(r101, "callback");
    L3:
        long r102 = r100.f253121c.get();
        if (r102 == 0) goto L51;
        if (r102 == Long.MAX_VALUE) goto L49;
        if (r100.f253121c.compareAndSet(r102, 1 + r102) == false) goto L3;
        Pointer r103 = r100.f253119a;     // Catch: Throwable -> L43
        s r113 = s.f253114a;     // Catch: Throwable -> L43
        NativeLib.Companion r104 = NativeLib.Companion;     // Catch: Throwable -> L43
        m0 r105 = new m0(Long.valueOf(Pointer.nativeValue(r103)), "requestBitablePermissionInWorkspace");     // Catch: Throwable -> L43
        r104.getClass();     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r105, "info");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Throwable -> L43
        int r106 = q.f253101b;     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r101, "callback");     // Catch: Throwable -> L43
        MoltenFfiInstanceMsg r114 = new MoltenFfiInstanceMsg(4125820939384348791L, Long.valueOf(r.f253103a.a(new q(r101))));     // Catch: Throwable -> L43
        String r107 = null;
        FuncParamsXb974c3e45c31adc5 r108 = new FuncParamsXb974c3e45c31adc5(r111, r114, null);     // Catch: Throwable -> L43
        int r115 = FuncParamsXb974c3e45c31adc5.ADAPTER.encodedSize(r108);     // Catch: Throwable -> L43
        if (r115 <= 0) goto L12;
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L43
        RustBuffer.ByValue r116 = RustBuffer.a.a(r115);     // Catch: Throwable -> L43
        Pointer r109 = r116.data;     // Catch: Throwable -> L43
        Intrinsics.checkNotNull(r109);     // Catch: Throwable -> L43
        o0 r117 = new o0(r109);     // Catch: Throwable -> L43
        r108.encode(r117);     // Catch: Throwable -> L43
        r117.close();     // Catch: Throwable -> L43
    L13:
        BufferCallStatus.ByValue r118 = NativeLib.Companion.a().molten_ffi_lark_bitable_call(NativeLib.Companion.b(), r103, -2108504273770935980L, r116);     // Catch: Throwable -> L43
        int r119 = r118.code;     // Catch: Throwable -> L43
        if (r119 != 0) goto L20;
        if (r100.f253121c.decrementAndGet() != 0) goto L58;
        r100.b();
        return;
    L58:
        return;
    L20:
        if (r119 == 1) goto L42;
        if (r119 != 2) goto L39;
        RustBuffer.ByValue r120 = r118.data;     // Catch: Throwable -> L43
        int r121 = r120.len;     // Catch: Throwable -> L43
        if (r121 > 0) goto L53;
        UnhandledException r122 = new UnhandledException("Rust panic");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r122, "e");     // Catch: Throwable -> L43
        throw r122;     // Catch: Throwable -> L43
    L53:
        Pointer r123 = r120.data;     // Catch: Throwable -> L34
        if (r123 == null) goto L28;
        byte[] r124 = r123.getByteArray(0, r121);     // Catch: Throwable -> L34
    L29:
        if (r124 == null) goto L31;
        r107 = new String(r124, Charsets.UTF_8);     // Catch: Throwable -> L34
    L31:
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L34
        RustBuffer.a r125 = RustBuffer.Companion;     // Catch: Throwable -> L43
        RustBuffer.ByValue r126 = r118.data;     // Catch: Throwable -> L43
        r125.getClass();     // Catch: Throwable -> L43
        RustBuffer.a.c(r126);     // Catch: Throwable -> L43
        UnhandledException r127 = new UnhandledException(r107);     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r127, "e");     // Catch: Throwable -> L43
        throw r127;     // Catch: Throwable -> L43
    L28:
        r124 = null;
    L34:
        th = move-exception;
        RustBuffer.a r128 = RustBuffer.Companion;     // Catch: Throwable -> L43
        RustBuffer.ByValue r129 = r118.data;     // Catch: Throwable -> L43
        r128.getClass();     // Catch: Throwable -> L43
        RustBuffer.a.c(r129);     // Catch: Throwable -> L43
        throw th;     // Catch: Throwable -> L43
    L39:
        UnhandledException r130 = new UnhandledException("Unknown rust call status: " + r118 + ".code");     // Catch: Throwable -> L43
        Intrinsics.checkNotNullParameter(r130, "e");     // Catch: Throwable -> L43
        throw r130;     // Catch: Throwable -> L43
    L42:
        throw ((Throwable) r113.a(r118.data));     // Catch: Throwable -> L43
    L12:
        RustBuffer.Companion.getClass();     // Catch: Throwable -> L43
        r116 = RustBuffer.a.a(0);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        if (r100.f253121c.decrementAndGet() != 0) goto L47;
        r100.b();
    L47:
        throw th;
    L49:
        throw new IllegalStateException(z.class.getSimpleName().concat(" call counter would overflow"));
    L51:
        throw new IllegalStateException(z.class.getSimpleName().concat(" object has already been destroyed"));
    }

    @Override // er5.b
    public final void f(Context r100, String r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "docToken");
        Intrinsics.checkNotNullParameter(r111, "onSuccess");
        j r101 = (j) ((LinkedHashMap) this.f564980c).get(r110);
        if (r101 == null) goto L5;
        String r102 = r101.f253077e;
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        String r104 = r100.getString(R.string.Bitable_BaseWorkspace_RemovedBaseSavedInLocation_Desc_Mob);
    L15:
        BearUDDialogBuilder r105 = new BearUDDialogBuilder(r100);
        r105.f240192a.title(R.string.Bitable_BaseWorkspace_RemoveBaseFromWorkspaceOrNot_Title);
        Intrinsics.checkNotNull(r104);
        r105.f(r104);
        r105.b(R.id.ud_dialog_btn_primary, R.string.Bitable_BaseWorkspace_Remove_Button, R.color.function_danger_fill_default, new g(r101, r100, this, r110, r111));
        h r106 = h.f565001a;
        r105.f240192a.addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, r106);
        r105.h();
        return;
    L14:
        r104 = xo5.a.c(r100, R.string.Bitable_BaseWorkspace_MembersFromWorkspaceDontHaveAccessAfterRemoval_Desc_Mob, "workspaceName", r102);
        goto L15
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @Override // er5.b
    public final void h(Context r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "docToken");
        Intrinsics.checkNotNullParameter(r110, "title");
        WorkspaceAction r102 = WorkspaceAction.NewTo;
        NewBaseEntry r103 = NewBaseEntry.CreateCopy;
        NewBaseType r111 = NewBaseType.App;
        if ((28 & 64) == 0) goto L5;
        NewBaseType r104 = null;
    L7:
        if ((28 & 128) == 0) goto L9;
        NewBaseEntry r105 = null;
    L10:
        e(r100, r102, null, null, r104, r105);
        return;
    L9:
        r105 = r103;
        goto L10
    L5:
        r104 = r111;
        goto L7
    }

    @Override // er5.b
    public final void e(Context r100, WorkspaceAction r101, String r102, String r110, NewBaseType r111, NewBaseEntry r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        j r103 = (j) ((LinkedHashMap) this.f564980c).get(r102);
        if (r103 == null) goto L5;
        String r104 = r103.f253076d;
    L7:
        if (r101 != WorkspaceAction.Select) goto L9;
        int r105 = 5;
    L10:
        int r106 = b.f564981a[r101.ordinal()];
        if (r106 != 1) goto L13;
        WorkspaceSearchPanelType r107 = WorkspaceSearchPanelType.MoveInWorkspace;
    L20:
        LinkedHashMap r108 = new LinkedHashMap();
        if (r104 == null) goto L23;
        r108.put("workspaceToken", r104);
    L23:
        if (r107 == null) goto L25;
        r108.put("workspaceScene", r107.getScene());
    L25:
        if (r105 != 4) goto L31;
        j r109 = (j) ((LinkedHashMap) this.f564980c).get(r102);
        if (r109 == null) goto L31;
        String r113 = r109.f253077e;
        if (r113 == null) goto L31;
        r108.put("currentWorkspaceName", r113);
    L31:
        if (r110 == null) goto L33;
        r108.put("containerEnv", r110);
    L33:
        if (r111 == null) goto L35;
        r108.put("newBaseType", r111.getValue());
    L35:
        if (r112 == null) goto L37;
        r108.put("newBaseEntry", r112.getValue());
    L37:
        xs4.b r114 = new xs4.b(r100, r105, r108);
        BottomSheetDialog r115 = r114.f564973a;
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L45;
        DialogLancet.handleBlockedDialogShow(r115);
    L42:
        r114.f564974b.k("bitable.exposure", null);
        return;
    L45:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L44
    L41:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        goto L42
    L13:
        if (r106 != 2) goto L15;
        r107 = WorkspaceSearchPanelType.ChangeWorkspace;
        goto L20
    L15:
        if (r106 == 3) goto L17;
        r107 = null;
        goto L20
    L17:
        r107 = WorkspaceSearchPanelType.NewToWorkspace;
        goto L20
    L9:
        r105 = 4;
        goto L10
    L5:
        r104 = null;
        goto L7
    }
}
