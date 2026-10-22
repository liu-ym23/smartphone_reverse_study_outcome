package com.ss.android.lark.officesdk.minutes.api.recording.doubao.applet.route;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/doubao/applet/route/MmAppletPage;", "", "path", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "INDEX", "HOME", State.RECORDING, "END_WINDOW", "Companion", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmAppletPage extends Enum<MmAppletPage> {
    public static final a Companion = null;
    public static final MmAppletPage END_WINDOW = null;
    public static final MmAppletPage HOME = null;
    public static final MmAppletPage INDEX = null;
    public static final MmAppletPage RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmAppletPage[] f433573a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433574b = null;
    private final String path;

    public static final class a {
        public a() {
        }

        public static String a(MmAppletPage r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "page");
            Intrinsics.checkNotNullParameter(r101, "id");
            return r100.getPath() + '_' + r101;
        }
    }

    public static EnumEntries<MmAppletPage> getEntries() {
        return f433574b;
    }

    static {
        MmAppletPage r100 = new MmAppletPage("INDEX", 0, "index");
        INDEX = r100;
        MmAppletPage r101 = new MmAppletPage("HOME", 1, "home");
        HOME = r101;
        MmAppletPage r102 = new MmAppletPage(State.RECORDING, 2, "recording");
        RECORDING = r102;
        MmAppletPage r103 = new MmAppletPage("END_WINDOW", 3, "endwindow");
        END_WINDOW = r103;
        MmAppletPage[] r104 = {r100, r101, r102, r103};
        f433573a = r104;
        f433574b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MmAppletPage[] values() {
        return (MmAppletPage[]) f433573a.clone();
    }

    public final String getPath() {
        return this.path;
    }

    public static MmAppletPage valueOf(String r100) {
        return (MmAppletPage) r27.a.a(MmAppletPage.class, r100);
    }

    public MmAppletPage(String r100, int r101, String r102) {
        super(r100, r101);
        this.path = r102;
    }
}
