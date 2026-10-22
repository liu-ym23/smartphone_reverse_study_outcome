package com.hihonor.mcs.system.diagnosis.core;

import com.hihonor.mcs.system.diagnosis.core.pressure.PressureCallback;
import com.hihonor.mcs.system.diagnosis.core.pressure.PressurePayload;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class BinderCallbackWrapper extends IPressureCallbackPayload.Stub implements Runnable {
    private static final String TAG = null;
    IDoPlayloadComplete mCompletion;
    private Executor mExecutor;
    private PressureCallback pressureCallback;
    private PressurePayload pressurePayload;
    private ClassType type;

    public static final enum ClassType extends Enum<ClassType> {
        public static final ClassType PRESSURE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClassType[] f276634a = null;

        static {
            ClassType r100 = new ClassType();
            PRESSURE = r100;
            f276634a = new ClassType[]{r100};
        }

        public ClassType() {
            super("PRESSURE", 0);
        }

        public static ClassType valueOf(String r100) {
            return (ClassType) r27.a.a(ClassType.class, r100);
        }

        public static ClassType[] values() {
            return (ClassType[]) f276634a.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f276635a = null;

        static {
            int[] r100 = new int[ClassType.values().length];
            f276635a = r100;
            r100[ClassType.PRESSURE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    static {
        TAG = "BinderCallbackWrapper";
    }

    public BinderCallbackWrapper(PressureCallback r100) {
        this.pressureCallback = null;
        this.pressurePayload = new PressurePayload();
        this.pressureCallback = r100;
        this.type = ClassType.PRESSURE;
    }

    public void com_hihonor_mcs_system_diagnosis_core_BinderCallbackWrapper__run$___twin___() {
    L13:
        th = move-exception;
        IDoPlayloadComplete r100 = this.mCompletion;     // Catch: Exception -> L18
        if (r100 == null) goto L20;
        r100.doPayloadComplete(this);     // Catch: Exception -> L18
    L20:
        throw th;
    L18:
        e = move-exception;
        e.getMessage();
        goto L20
    L3:
        if (a.f276635a[this.type.ordinal()] != 1) goto L23;
        this.pressureCallback.onPressureReported(this.pressurePayload);     // Catch: Throwable -> L13
    L23:
        IDoPlayloadComplete r101 = this.mCompletion;     // Catch: Exception -> L10
        if (r101 == null) goto L27;
        r101.doPayloadComplete(this);     // Catch: Exception -> L10
        return;
    L27:
        return;
    L10:
        e = move-exception;
        e.getMessage();
    }

    @Override // java.lang.Runnable
    public void run() {
        com_hihonor_mcs_system_diagnosis_core_BinderCallbackWrapper_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void setExecutor(Executor r100) {
        this.mExecutor = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_hihonor_mcs_system_diagnosis_core_BinderCallbackWrapper_com_larus_apm_impl_protector_RunnableLancet_run(BinderCallbackWrapper r100) {
        r100.com_hihonor_mcs_system_diagnosis_core_BinderCallbackWrapper__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.IPressureCallbackPayload
    public void receivePayloadData(PressureCallbackPayload r100, IDoPlayloadComplete r101) {
        if (a.f276635a[this.type.ordinal()] != 1) goto L7;
        if (r100 == null) goto L7;
        this.pressurePayload = r100.f276637a;
    L7:
        this.mCompletion = r101;
        this.mExecutor.execute(this);
    }
}
