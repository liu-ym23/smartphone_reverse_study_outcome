package com.bytedance.lark.sdk;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.obric.miniapp.alarm.AccountType;
import java.io.ByteArrayOutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class LarkResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f254081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResponseStatus f254082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f254083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f254084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f254085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f254086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f254087g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/sdk/LarkResponse$InnerErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "WAIT_TIMEOUT", "MEMORY_LIMIT", "toInt", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InnerErrorCode extends Enum<InnerErrorCode> {
        public static final InnerErrorCode MEMORY_LIMIT = null;
        public static final InnerErrorCode UNKNOWN = null;
        public static final InnerErrorCode WAIT_TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InnerErrorCode[] f254088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254089b = null;
        private int value;

        public static EnumEntries<InnerErrorCode> getEntries() {
            return f254089b;
        }

        static {
            InnerErrorCode r100 = new InnerErrorCode("UNKNOWN", 0, 2000);
            UNKNOWN = r100;
            InnerErrorCode r101 = new InnerErrorCode("WAIT_TIMEOUT", 1, 2001);
            WAIT_TIMEOUT = r101;
            InnerErrorCode r102 = new InnerErrorCode("MEMORY_LIMIT", 2, 2002);
            MEMORY_LIMIT = r102;
            InnerErrorCode[] r103 = {r100, r101, r102};
            f254088a = r103;
            f254089b = EnumEntriesKt.enumEntries(r103);
        }

        public static InnerErrorCode[] values() {
            return (InnerErrorCode[]) f254088a.clone();
        }

        public final int toInt() {
            return this.value;
        }

        public static InnerErrorCode valueOf(String r100) {
            return (InnerErrorCode) r27.a.a(InnerErrorCode.class, r100);
        }

        public InnerErrorCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/lark/sdk/LarkResponse$ResponseStatus;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SUCCESS", "CANCEL", "ERROR", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ResponseStatus extends Enum<ResponseStatus> {
        public static final ResponseStatus CANCEL = null;
        public static final ResponseStatus ERROR = null;
        public static final ResponseStatus SUCCESS = null;
        public static final ResponseStatus UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResponseStatus[] f254090a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254091b = null;

        public static EnumEntries<ResponseStatus> getEntries() {
            return f254091b;
        }

        static {
            ResponseStatus r100 = new ResponseStatus("UNKNOWN", 0);
            UNKNOWN = r100;
            ResponseStatus r101 = new ResponseStatus("SUCCESS", 1);
            SUCCESS = r101;
            ResponseStatus r102 = new ResponseStatus("CANCEL", 2);
            CANCEL = r102;
            ResponseStatus r103 = new ResponseStatus("ERROR", 3);
            ERROR = r103;
            ResponseStatus[] r104 = {r100, r101, r102, r103};
            f254090a = r104;
            f254091b = EnumEntriesKt.enumEntries(r104);
        }

        public static ResponseStatus[] values() {
            return (ResponseStatus[]) f254090a.clone();
        }

        public static ResponseStatus valueOf(String r100) {
            return (ResponseStatus) r27.a.a(ResponseStatus.class, r100);
        }

        public ResponseStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/sdk/LarkResponse$SdkErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "TIMEOUT", AccountType.OTHERS, "SDK", "OFFLINE", "IO", "toInt", "rust-jvm_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SdkErrorCode extends Enum<SdkErrorCode> {
        public static final SdkErrorCode IO = null;
        public static final SdkErrorCode OFFLINE = null;
        public static final SdkErrorCode OTHERS = null;
        public static final SdkErrorCode SDK = null;
        public static final SdkErrorCode TIMEOUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SdkErrorCode[] f254092a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254093b = null;
        private int value;

        public static EnumEntries<SdkErrorCode> getEntries() {
            return f254093b;
        }

        static {
            SdkErrorCode r100 = new SdkErrorCode("TIMEOUT", 0, 1000);
            TIMEOUT = r100;
            SdkErrorCode r101 = new SdkErrorCode(AccountType.OTHERS, 1, 1001);
            OTHERS = r101;
            SdkErrorCode r102 = new SdkErrorCode("SDK", 2, 1002);
            SDK = r102;
            SdkErrorCode r103 = new SdkErrorCode("OFFLINE", 3, 1003);
            OFFLINE = r103;
            SdkErrorCode r104 = new SdkErrorCode("IO", 4, 1004);
            IO = r104;
            SdkErrorCode[] r105 = {r100, r101, r102, r103, r104};
            f254092a = r105;
            f254093b = EnumEntriesKt.enumEntries(r105);
        }

        public static SdkErrorCode[] values() {
            return (SdkErrorCode[]) f254092a.clone();
        }

        public final int toInt() {
            return this.value;
        }

        public static SdkErrorCode valueOf(String r100) {
            return (SdkErrorCode) r27.a.a(SdkErrorCode.class, r100);
        }

        public SdkErrorCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f254094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ResponseStatus f254095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f254096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f254097d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f254098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f254099f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f254100g;

        public a() {
            this.f254095b = ResponseStatus.UNKNOWN;
            this.f254100g = "";
        }

        public final void a(ResponseStatus r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f254095b = r100;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InnerErrorCode f254101a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f254102b;

        public b(InnerErrorCode r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "innerErrorCode");
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f254101a = r100;
            this.f254102b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f254103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteArrayOutputStream f254104b;

        public static final class a {
        }

        static {
        }

        public c(String r100, ByteArrayOutputStream r101) {
            Intrinsics.checkNotNullParameter(r100, "contentType");
            Intrinsics.checkNotNullParameter(r101, ContainerPosition.BODY);
            this.f254103a = r100;
            this.f254104b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SdkErrorCode f254105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f254106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f254107c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f254108d;

        public d(SdkErrorCode r100, String r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "sdkErrorCode");
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f254105a = r100;
            this.f254106b = r101;
            this.f254107c = r102;
            this.f254108d = r103;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f254109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LarkNetProtocol f254110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<com.bytedance.lark.sdk.a> f254111c;

        public e(int r100, LarkNetProtocol r101, List<com.bytedance.lark.sdk.a> r102) {
            Intrinsics.checkNotNullParameter(r101, "protocol");
            Intrinsics.checkNotNullParameter(r102, "headers");
            this.f254109a = r100;
            this.f254110b = r101;
            this.f254111c = r102;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f254112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f254113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f254114c;

        public f(int r100, int r101, int r102) {
            this.f254112a = r100;
            this.f254113b = r101;
            this.f254114c = r102;
        }
    }

    public LarkResponse(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f254082b = ResponseStatus.UNKNOWN;
        this.f254087g = "";
        this.f254081a = r100.f254094a;
        this.f254082b = r100.f254095b;
        this.f254083c = r100.f254096c;
        this.f254084d = r100.f254097d;
        this.f254085e = r100.f254098e;
        this.f254086f = r100.f254099f;
        this.f254087g = r100.f254100g;
    }
}
