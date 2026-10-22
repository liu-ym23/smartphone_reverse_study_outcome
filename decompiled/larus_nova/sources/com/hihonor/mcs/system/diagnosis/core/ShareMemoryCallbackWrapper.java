package com.hihonor.mcs.system.diagnosis.core;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.douyin.janna.platform.HONORProcessor;
import com.hihonor.mcs.system.diagnosis.core.performance.PerformancePayload;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalMetric;
import com.hihonor.mcs.system.diagnosis.core.powerthermal.PowerThermalPayload;
import com.hihonor.mcs.system.diagnosis.core.stability.StabilityPayload;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ShareMemoryCallbackWrapper extends ICallbackPayload.Stub implements Runnable {
    private static final String TAG = "ShareMemoryCallbackWrapper";
    IDoPlayloadComplete mCompletion;
    private Executor mExecutor;
    private sw7.a performanceCallback;
    private PerformancePayload performancePayload;
    private tw7.a powerThermalCallback;
    private PowerThermalPayload powerThermalPayload;
    private uw7.a stabilityCallback;
    private StabilityPayload stabilityPayload;
    private ClassType type;

    public static final enum ClassType extends Enum<ClassType> {
        public static final ClassType PERFORMANCE = null;
        public static final ClassType POWERTHERMAL = null;
        public static final ClassType STABILITY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClassType[] f276638a = null;

        static {
            ClassType r100 = new ClassType("STABILITY", 0);
            STABILITY = r100;
            ClassType r101 = new ClassType("PERFORMANCE", 1);
            PERFORMANCE = r101;
            ClassType r102 = new ClassType("POWERTHERMAL", 2);
            POWERTHERMAL = r102;
            f276638a = new ClassType[]{r100, r101, r102};
        }

        public ClassType(String r100, int r101) {
            super(r100, r101);
        }

        public static ClassType valueOf(String r100) {
            return (ClassType) r27.a.a(ClassType.class, r100);
        }

        public static ClassType[] values() {
            return (ClassType[]) f276638a.clone();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f276639a = null;

        static {
            int[] r100 = new int[ClassType.values().length];
            f276639a = r100;
            r100[ClassType.STABILITY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f276639a[ClassType.PERFORMANCE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f276639a[ClassType.POWERTHERMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public ShareMemoryCallbackWrapper(sw7.a r100) {
        this.stabilityCallback = null;
        this.powerThermalCallback = null;
        this.stabilityPayload = new StabilityPayload();
        this.performancePayload = new PerformancePayload();
        this.powerThermalPayload = new PowerThermalPayload();
        this.type = ClassType.PERFORMANCE;
    }

    public ShareMemoryCallbackWrapper(tw7.a r100) {
        this.stabilityCallback = null;
        this.powerThermalCallback = null;
        this.stabilityPayload = new StabilityPayload();
        this.performancePayload = new PerformancePayload();
        this.powerThermalPayload = new PowerThermalPayload();
        this.powerThermalCallback = r100;
        this.type = ClassType.POWERTHERMAL;
    }

    public ShareMemoryCallbackWrapper(uw7.a r100) {
        this.stabilityCallback = null;
        this.powerThermalCallback = null;
        this.stabilityPayload = new StabilityPayload();
        this.performancePayload = new PerformancePayload();
        this.powerThermalPayload = new PowerThermalPayload();
        this.stabilityCallback = r100;
        this.type = ClassType.STABILITY;
    }

    public void com_hihonor_mcs_system_diagnosis_core_ShareMemoryCallbackWrapper__run$___twin___() {
        int r100 = a.f276639a[this.type.ordinal()];     // Catch: Throwable -> L20
        if (r100 != 1) goto L5;
        uw7.a r101 = this.stabilityCallback;     // Catch: Throwable -> L20
        HONORProcessor.StabilityCallbackImpl r102 = (HONORProcessor.StabilityCallbackImpl) r101;     // Catch: Throwable -> L20
        r102.a(this.stabilityPayload);     // Catch: Throwable -> L20
    L30:
        IDoPlayloadComplete r103 = this.mCompletion;     // Catch: Exception -> L17
        if (r103 == null) goto L33;
        r103.doPayloadComplete(this);     // Catch: Exception -> L17
        return;
    L33:
        return;
    L17:
        e = move-exception;
        e.getMessage();
        return;
    L5:
        if (r100 == 2) goto L11;
        if (r100 != 3) goto L30;
        this.powerThermalCallback.a(this.powerThermalPayload);     // Catch: Throwable -> L20
        goto L30
    L11:
        throw null;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        IDoPlayloadComplete r104 = this.mCompletion;     // Catch: Exception -> L25
        if (r104 == null) goto L27;
        r104.doPayloadComplete(this);     // Catch: Exception -> L25
    L27:
        throw th;
    L25:
        e = move-exception;
        e.getMessage();
        goto L27
    }

    @Override // com.hihonor.mcs.system.diagnosis.core.ICallbackPayload
    public void receivePayloadData(CallbackPayload r100, IDoPlayloadComplete r101) {
        int r102 = a.f276639a[this.type.ordinal()];     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        if (r102 != 1) goto L5;
        if (r100 == null) goto L33;
        this.stabilityPayload = (StabilityPayload) getPayloadObjectFromRemote(StabilityPayload.class, r100);     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
    L33:
        this.mCompletion = r101;
        this.mExecutor.execute(this);
        return;
    L5:
        if (r102 != 2) goto L7;
        if (r100 == null) goto L33;
        this.performancePayload = (PerformancePayload) getPayloadObjectFromRemote(PerformancePayload.class, r100);     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        goto L33
    L7:
        if (r102 != 3) goto L33;
        if (r100 == null) goto L33;
        this.powerThermalPayload = (PowerThermalPayload) getPayloadObjectFromRemote(PowerThermalPayload.class, r100);     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        int r103 = Process.myPid();     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        List<PowerThermalMetric> r104 = this.powerThermalPayload.getPowerThermalMetrics();     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        if (r104 == null) goto L33;
        if (r104.isEmpty() == true) goto L33;
        Iterator<PowerThermalMetric> r105 = r104.iterator();     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
    L16:
        if (r105.hasNext() == false) goto L33;
        PowerThermalMetric r106 = r105.next();     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
        if (r106.getPid() != 0) goto L16;
        r106.setPid(r103);     // Catch: InvocationTargetException -> L25 Throwable -> L27 InstantiationException -> L29 IllegalAccessException -> L31
    L27:
        e = move-exception;
        e.getMessage();
        goto L33
    }

    @Override // java.lang.Runnable
    public void run() {
        com_hihonor_mcs_system_diagnosis_core_ShareMemoryCallbackWrapper_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void setExecutor(Executor r100) {
        this.mExecutor = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_hihonor_mcs_system_diagnosis_core_ShareMemoryCallbackWrapper_com_larus_apm_impl_protector_RunnableLancet_run(ShareMemoryCallbackWrapper r100) {
        r100.com_hihonor_mcs_system_diagnosis_core_ShareMemoryCallbackWrapper__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T getPayloadObjectFromRemote(Class<T> r100, CallbackPayload r110) {
        T r101 = r100.getConstructor(new Class[0]).newInstance(new Object[0]);
        T r102 = r101;
        ParcelFileDescriptor r111 = r110.f276636a;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        PolarisFileInputStreamWrapper r104 = null;
        ObjectInputStream r105 = null;
        r105 = null;
        r104 = null;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(r111.getFileDescriptor());     // Catch: Throwable -> L35 ClassNotFoundException -> L38 IOException -> L40
    L78:
        byte[] r107 = new byte[1024];     // Catch: Throwable -> L29 ClassNotFoundException -> L31 IOException -> L33
    L6:
        int r108 = r106.read(r107);     // Catch: Throwable -> L29 ClassNotFoundException -> L31 IOException -> L33
        if (r108 == (-1)) goto L9;
        r103.write(r107, 0, r108);     // Catch: Throwable -> L29 ClassNotFoundException -> L31 IOException -> L33
        goto L6
    L9:
        r103.flush();     // Catch: Throwable -> L29 ClassNotFoundException -> L31 IOException -> L33
        ByteArrayInputStream r109 = new ByteArrayInputStream(r103.toByteArray());     // Catch: Throwable -> L29 ClassNotFoundException -> L31 IOException -> L33
        ObjectInputStream r112 = new ObjectInputStream(r109);     // Catch: Throwable -> L22 ClassNotFoundException -> L24 IOException -> L26
    L76:
        r102 = (T) r112.readObject();
        r103.close();     // Catch: IOException -> L14
        r106.close();     // Catch: IOException -> L14
        r111.close();     // Catch: IOException -> L14
        r112.close();     // Catch: IOException -> L14
        r109.close();     // Catch: IOException -> L14
    L53:
        return r102;
    L20:
        e = e;
    L21:
        r105 = r112;
        e = e;
    L28:
        r104 = r106;
        ByteArrayInputStream r113 = r109;
    L68:
        e.getMessage();     // Catch: Throwable -> L54
        r103.close();     // Catch: IOException -> L14
        if (r104 == null) goto L47;
        r104.close();     // Catch: IOException -> L14
    L47:
        if (r111 == null) goto L49;
        r111.close();     // Catch: IOException -> L14
    L49:
        if (r105 == null) goto L51;
        r105.close();     // Catch: IOException -> L14
    L51:
        if (r113 == 0) goto L53;
        r113.close();     // Catch: IOException -> L14
    L54:
        th = th;
    L71:
        r103.close();     // Catch: IOException -> L65
        if (r104 == null) goto L58;
        r104.close();     // Catch: IOException -> L65
    L58:
        if (r111 == null) goto L60;
        r111.close();     // Catch: IOException -> L65
    L60:
        if (r105 == null) goto L62;
        r105.close();     // Catch: IOException -> L65
    L62:
        if (r113 == 0) goto L67;
        r113.close();     // Catch: IOException -> L65
    L67:
        throw th;
    L65:
        e = move-exception;
        e.getMessage();
    L18:
        e = e;
    L16:
        th = th;
        r104 = r106;
        r113 = r109;
        r105 = r112;
    L26:
        e = e;
    L27:
        r105 = null;
    L24:
        e = e;
    L22:
        th = th;
        r105 = null;
        r104 = r106;
        r113 = r109;
        goto L71
    L33:
        e = e;
    L34:
        r104 = r106;
    L42:
        r113 = r104;
    L31:
        e = e;
    L29:
        th = th;
        r104 = r106;
    L37:
        r113 = r104;
    L14:
        e = move-exception;
        e.getMessage();
    L40:
        e = e;
    L38:
        e = e;
    L35:
        th = th;
        goto L37
    }
}
