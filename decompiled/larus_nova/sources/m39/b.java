package m39;

import com.larus.doc.impl.DocFragment;
import com.larus.doc.impl.offline.CreateDocByMessageActionType;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tx9.t0;
import tx9.u0;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511804a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f511805a = null;

        static {
            int[] r100 = new int[CreateDocByMessageActionType.values().length];
            r100[CreateDocByMessageActionType.FORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CreateDocByMessageActionType.COMPENSATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f511805a = r100;
        }
    }

    static {
    }

    public b() {
    }

    public static void a(String r100) {
        FLogger r101 = FLogger.f375446a;
        if (r101.isDebug() == false) goto L6;
        r101.i("OfflineDocReport", "mobDocOfflineCompensateCreate, " + r100);
        return;
    }

    public static String f(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L14;
        if (r100 != null) goto L11;
        return "null";
    L11:
        return "empty";
    L14:
        return "len=" + r100.length() + ",hash=" + r100.hashCode();
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "stage");
        StringBuilder r102 = new StringBuilder("等待创建离线文档结束, 当前阶段:");
        r102.append(r100);
        r102.append(", 原因:");
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.append(r101);
        a(r102.toString());
    }

    public static void e(com.larus.doc.impl.offline.b r110, DocFragment r111, int r112) {
        boolean r100 = false;
        if ((r112 & 2) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r112 & 4) == 0) goto L9;
        r111 = null;
    L9:
        DocFragment r102 = r111;
        Intrinsics.checkNotNullParameter(r110, "createDocByMessageState");
        CreateDocByMessageActionType r113 = r110.f331241a;
        CreateDocByMessageActionType r114 = CreateDocByMessageActionType.COMPENSATE;
        if (r113 != r114) goto L12;
        boolean r103 = true;
    L13:
        int r104 = t0.f547889a;
        if (r113 != r114) goto L16;
        r100 = true;
    L16:
        u0.a(t0.a(r100, r110.f331242b, r110.f331243c, r110.f331244d), r101, Boolean.valueOf(r103), Boolean.valueOf(r110.f331242b), Boolean.valueOf(r110.f331243c), Boolean.valueOf(r110.f331244d), r102);
        return;
    L12:
        r103 = false;
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    public static void c(String r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        StringBuilder r104 = new StringBuilder("刷新远端绑定, 来源:");
        r104.append(r100);
        r104.append(", realToken:");
        r104.append(f(r101));
        r104.append(", 是否已刷新:");
        r104.append(r102);
        r104.append(", 原因:");
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r104.append(r103);
        a(r104.toString());
    }

    public static void b(String r100, String r101, Boolean r102, String r103, com.larus.doc.impl.offline.b r110) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        Intrinsics.checkNotNullParameter(r110, "createDocByMessageState");
        CreateDocByMessageActionType r104 = r110.f331241a;
        CreateDocByMessageActionType r105 = CreateDocByMessageActionType.COMPENSATE;
        boolean r106 = false;
        if (r104 != r105) goto L5;
        boolean r107 = true;
    L6:
        int r108 = a.f511805a[r104.ordinal()];
        if (r108 != 1) goto L9;
        String r109 = "正常创建卡片";
    L14:
        int r111 = t0.f547889a;
        if (r110.f331241a != r105) goto L17;
        r106 = true;
    L17:
        a("卡片补偿决策, 是否补偿:" + r107 + ", 动作:" + r109 + ", 当前阶段:" + r100 + ", 是否有realToken:" + r110.f331242b + ", 是否已收到USER_CHANGES:" + r110.f331243c + ", 是否已前端绑定:" + r110.f331244d + ", realToken:" + f(r101) + ", 是否使用消息内容:" + r102 + ", 创建状态原因:" + t0.a(r106, r110.f331242b, r110.f331243c, r110.f331244d) + ", 旧失败原因:" + r103);
        return;
    L9:
        if (r108 != 2) goto L12;
        r109 = "补偿创建卡片";
        goto L14
    L12:
        throw new NoWhenBranchMatchedException();
    L5:
        r107 = false;
        goto L6
    }
}
