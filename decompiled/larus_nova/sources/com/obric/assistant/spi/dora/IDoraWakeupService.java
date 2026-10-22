package com.obric.assistant.spi.dora;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\bg\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\tH&J\b\u0010\u000f\u001a\u00020\tH&J\b\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\tH&J\b\u0010\u001d\u001a\u00020\tH&J\b\u0010\u001e\u001a\u00020\tH&¨\u0006!"}, d2 = {"Lcom/obric/assistant/spi/dora/IDoraWakeupService;", "", "handleDoraWakeup", "", "type", "Lcom/obric/assistant/spi/dora/IDoraWakeupService$WakeupType;", "vuiId", "", "needUpdate", "", "onQueryStop", "onSingleClick", "cancel", "setStopVUIWhenTtsEnd", "stop", "isInRadioPressing", "isInDoraVoiceWakeup", "setObricContTalkActive", "isActive", "isObricContTalkActive", "stopVUI", "stopVUIWhenTimeout", "setUseDefaultDora", "useDefault", "getUseDefaultDora", "doraSupportFeatureOTA3P5", "notifyDoraWakeupForEnroll", "notifyDoraGWakeupState", "isInWakeup", "isInDoraGWakeup", "isDoraProxyWakeup", "Companion", "WakeupType", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraWakeupService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f392868a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/spi/dora/IDoraWakeupService$WakeupType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "VOICE", "KEY", "RADIO", "SILENT", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum WakeupType extends Enum<WakeupType> {
        public static final WakeupType KEY = null;
        public static final WakeupType RADIO = null;
        public static final WakeupType SILENT = null;
        public static final WakeupType VOICE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ WakeupType[] f392869a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f392870b = null;
        private final int value;

        public static EnumEntries<WakeupType> getEntries() {
            return f392870b;
        }

        static {
            WakeupType r100 = new WakeupType("VOICE", 0, 0);
            VOICE = r100;
            WakeupType r101 = new WakeupType("KEY", 1, 1);
            KEY = r101;
            WakeupType r102 = new WakeupType("RADIO", 2, 2);
            RADIO = r102;
            WakeupType r103 = new WakeupType("SILENT", 3, 3);
            SILENT = r103;
            WakeupType[] r104 = {r100, r101, r102, r103};
            f392869a = r104;
            f392870b = EnumEntriesKt.enumEntries(r104);
        }

        public static WakeupType[] values() {
            return (WakeupType[]) f392869a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static WakeupType valueOf(String r100) {
            return (WakeupType) r27.a.a(WakeupType.class, r100);
        }

        public WakeupType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f392871a = null;

        static {
            f392871a = new a();
        }

        public a() {
        }
    }

    static {
        f392868a = a.f392871a;
    }

    void a();

    boolean b();

    boolean c();

    void cancel();

    void d(boolean r100);

    boolean e();

    boolean f();

    boolean g();

    void h();

    void i(boolean r100);

    void j(boolean r100);

    void k(int r100);

    void l(boolean r100);

    void m();

    boolean n();

    boolean o();

    void p();

    void q(WakeupType r100, int r101, boolean r102);
}
