package com.ss.android.lark.passport.flow.mfa;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0080\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0016\u0017B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor;", "", "wireKey", "", ReportConstant.COMMON_ACTION_TYPE, "", "inputKind", "Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;)V", "getWireKey", "()Ljava/lang/String;", "getActionType", "()I", "getInputKind", "()Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "PHONE", CommonConstant.RETKEY.EMAIL, "SPARE", "OTP", "PASSWORD", "BIDP", "InputKind", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FlowVerifyFactor extends Enum<FlowVerifyFactor> {
    public static final FlowVerifyFactor BIDP = null;
    public static final a Companion = null;
    public static final FlowVerifyFactor EMAIL = null;
    public static final FlowVerifyFactor OTP = null;
    public static final FlowVerifyFactor PASSWORD = null;
    public static final FlowVerifyFactor PHONE = null;
    public static final FlowVerifyFactor SPARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<FlowVerifyFactor> f437877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f437878b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ FlowVerifyFactor[] f437879c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437880d = null;
    private final int actionType;
    private final InputKind inputKind;
    private final String wireKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/passport/flow/mfa/FlowVerifyFactor$InputKind;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "OTP", "PASSWORD", "BIDP", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InputKind extends Enum<InputKind> {
        public static final InputKind BIDP = null;
        public static final InputKind CODE = null;
        public static final InputKind OTP = null;
        public static final InputKind PASSWORD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InputKind[] f437881a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f437882b = null;

        public static EnumEntries<InputKind> getEntries() {
            return f437882b;
        }

        static {
            InputKind r100 = new InputKind("CODE", 0);
            CODE = r100;
            InputKind r101 = new InputKind("OTP", 1);
            OTP = r101;
            InputKind r102 = new InputKind("PASSWORD", 2);
            PASSWORD = r102;
            InputKind r103 = new InputKind("BIDP", 3);
            BIDP = r103;
            InputKind[] r104 = {r100, r101, r102, r103};
            f437881a = r104;
            f437882b = EnumEntriesKt.enumEntries(r104);
        }

        public static InputKind[] values() {
            return (InputKind[]) f437881a.clone();
        }

        public static InputKind valueOf(String r100) {
            return (InputKind) r27.a.a(InputKind.class, r100);
        }

        public InputKind(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        public static FlowVerifyFactor a(int r100) {
            Iterator r101 = FlowVerifyFactor.access$getSupported$cp().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            Object r102 = r101.next();
            if (((FlowVerifyFactor) r102).getActionType() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L13:
            return (FlowVerifyFactor) r102;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L13
        }

        public static boolean b(int r100) {
            return FlowVerifyFactor.access$getSupportedActionTypes$cp().contains(Integer.valueOf(r100));
        }
    }

    public static EnumEntries<FlowVerifyFactor> getEntries() {
        return f437880d;
    }

    static {
        InputKind r110 = InputKind.CODE;
        FlowVerifyFactor r100 = new FlowVerifyFactor("PHONE", 0, "verify_code_mobile", 12, r110);
        PHONE = r100;
        FlowVerifyFactor r101 = new FlowVerifyFactor(CommonConstant.RETKEY.EMAIL, 1, "verify_code_email", 11, r110);
        EMAIL = r101;
        FlowVerifyFactor r102 = new FlowVerifyFactor("SPARE", 2, "verify_code_spare", 43, r110);
        SPARE = r102;
        FlowVerifyFactor r103 = new FlowVerifyFactor("OTP", 3, "verify_otp", 42, InputKind.OTP);
        OTP = r103;
        FlowVerifyFactor r104 = new FlowVerifyFactor("PASSWORD", 4, "verify_pwd", 41, InputKind.PASSWORD);
        PASSWORD = r104;
        FlowVerifyFactor r105 = new FlowVerifyFactor("BIDP", 5, "verify_b_idp", 23, InputKind.BIDP);
        BIDP = r105;
        FlowVerifyFactor[] r106 = {r100, r101, r102, r103, r104, r105};
        f437879c = r106;
        f437880d = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
        Set<FlowVerifyFactor> r107 = SetsKt.setOf(new FlowVerifyFactor[]{r100, r101, r105});
        f437877a = r107;
        Set<FlowVerifyFactor> r108 = r107;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r111 = r108.iterator();
    L4:
        if (r111.hasNext() == false) goto L6;
        r109.add(Integer.valueOf(((FlowVerifyFactor) r111.next()).actionType));
        goto L4
    L6:
        f437878b = CollectionsKt.toSet(r109);
    }

    public static FlowVerifyFactor[] values() {
        return (FlowVerifyFactor[]) f437879c.clone();
    }

    public static final /* synthetic */ Set access$getSupported$cp() {
        return f437877a;
    }

    public static final /* synthetic */ Set access$getSupportedActionTypes$cp() {
        return f437878b;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final InputKind getInputKind() {
        return this.inputKind;
    }

    public final String getWireKey() {
        return this.wireKey;
    }

    public static FlowVerifyFactor valueOf(String r100) {
        return (FlowVerifyFactor) r27.a.a(FlowVerifyFactor.class, r100);
    }

    public FlowVerifyFactor(String r100, int r101, String r102, int r103, InputKind r104) {
        super(r100, r101);
        this.wireKey = r102;
        this.actionType = r103;
        this.inputKind = r104;
    }
}
