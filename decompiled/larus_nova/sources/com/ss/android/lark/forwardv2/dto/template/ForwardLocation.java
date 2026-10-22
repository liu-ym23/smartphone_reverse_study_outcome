package com.ss.android.lark.forwardv2.dto.template;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.lark.dependency.IForwardDependency$ForwardLocation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forwardv2/dto/template/ForwardLocation;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", FlowDoraWifiScene.OTHER, "FILE", "PIN", "CHAT", "IMAGE", HTTP.LOCATION, "FAVOURITE", "THREAD", "THREAD_DETAIL", "MSG_THREAD", "Companion", "forward-v2_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForwardLocation extends Enum<ForwardLocation> {
    public static final ForwardLocation CHAT = null;
    public static final a Companion = null;
    public static final ForwardLocation FAVOURITE = null;
    public static final ForwardLocation FILE = null;
    public static final ForwardLocation IMAGE = null;
    public static final ForwardLocation LOCATION = null;
    public static final ForwardLocation MSG_THREAD = null;
    public static final ForwardLocation OTHER = null;
    public static final ForwardLocation PIN = null;
    public static final ForwardLocation THREAD = null;
    public static final ForwardLocation THREAD_DETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForwardLocation[] f424849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f424850b = null;
    private String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static ForwardLocation a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            switch(r100.hashCode()) {
                case -1442714871: goto L42;
                case -874443254: goto L38;
                case -855114483: goto L34;
                case -689102712: goto L30;
                case 110997: goto L26;
                case 3052376: goto L22;
                case 106069776: goto L18;
                case 1050790300: goto L14;
                case 1901043637: goto L10;
                case 2062274776: goto L6;
                default: goto L46;
            };
        L6:
            if (r100.equals("in_file_page") == false) goto L46;
            return ForwardLocation.FILE;
        L10:
            if (r100.equals("location") == false) goto L46;
            return ForwardLocation.LOCATION;
        L14:
            if (r100.equals("favorite") == false) goto L46;
            return ForwardLocation.FAVOURITE;
        L18:
            if (r100.equals("other") == false) goto L46;
            return ForwardLocation.OTHER;
        L22:
            if (r100.equals("chat") == false) goto L46;
            return ForwardLocation.CHAT;
        L26:
            if (r100.equals("pin") == false) goto L46;
            return ForwardLocation.PIN;
        L30:
            if (r100.equals(IForwardDependency$ForwardLocation.MSG_THREAD) == false) goto L46;
            return ForwardLocation.MSG_THREAD;
        L34:
            if (r100.equals("thread_details") == false) goto L46;
            return ForwardLocation.THREAD_DETAIL;
        L38:
            if (r100.equals("thread") == false) goto L46;
            return ForwardLocation.THREAD;
        L42:
            if (r100.equals("image_view") == false) goto L46;
            return ForwardLocation.IMAGE;
        L46:
            return ForwardLocation.OTHER;
        }
    }

    @JvmStatic
    public static final ForwardLocation forNumber(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<ForwardLocation> getEntries() {
        return f424850b;
    }

    static {
        ForwardLocation r100 = new ForwardLocation(FlowDoraWifiScene.OTHER, 0, "other");
        OTHER = r100;
        ForwardLocation r101 = new ForwardLocation("FILE", 1, "in_file_page");
        FILE = r101;
        ForwardLocation r102 = new ForwardLocation("PIN", 2, "pin");
        PIN = r102;
        ForwardLocation r103 = new ForwardLocation("CHAT", 3, "chat");
        CHAT = r103;
        ForwardLocation r104 = new ForwardLocation("IMAGE", 4, "image_view");
        IMAGE = r104;
        ForwardLocation r105 = new ForwardLocation(HTTP.LOCATION, 5, "location");
        LOCATION = r105;
        ForwardLocation r110 = new ForwardLocation("FAVOURITE", 6, "favorite");
        FAVOURITE = r110;
        ForwardLocation r111 = new ForwardLocation("THREAD", 7, "thread");
        THREAD = r111;
        ForwardLocation r112 = new ForwardLocation("THREAD_DETAIL", 8, "thread_details");
        THREAD_DETAIL = r112;
        ForwardLocation r113 = new ForwardLocation("MSG_THREAD", 9, IForwardDependency$ForwardLocation.MSG_THREAD);
        MSG_THREAD = r113;
        ForwardLocation[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f424849a = r106;
        f424850b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static ForwardLocation[] values() {
        return (ForwardLocation[]) f424849a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ForwardLocation valueOf(String r100) {
        return (ForwardLocation) r27.a.a(ForwardLocation.class, r100);
    }

    public final void setValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.value = r100;
    }

    public ForwardLocation(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
