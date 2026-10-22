package j6c;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.biz.im.api.extension.message.TaskType;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.suite.lark.component.protocol.Biz;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: j6c.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6397a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f497554a = null;

        static {
            int[] r100 = new int[Biz.values().length];
            r100[Biz.Passport.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r100[Biz.Core.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r100[Biz.IM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[Biz.KA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[Biz.Infra.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r100[Biz.Mail.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r100[Biz.Meego.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r100[Biz.OpenPlatform.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r100[Biz.Search.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r100[Biz.Security.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r100[Biz.Todo.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r100[Biz.VC.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r100[Biz.UG.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r100[Biz.Minutes.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r100[Biz.CCM.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r100[Biz.Common.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r100[Biz.Performance.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[Biz.Calendar.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            f497554a = r100;
        }
    }

    public static final com.ss.android.lark.storage.a a(Biz r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(C6397a.f497554a[r100.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            case 18: goto L5;
            default: goto L4;
        };
    L4:
        String r101 = r100.name();
    L24:
        return new com.ss.android.lark.storage.a(r101);
    L5:
        r101 = "calendar";
        goto L24
    L6:
        r101 = "Performance";
        goto L24
    L7:
        r101 = "Common";
        goto L24
    L8:
        r101 = r100.name();
        goto L24
    L9:
        r101 = DocumentType.MINUTES_NAME;
        goto L24
    L10:
        r101 = "ug";
        goto L24
    L11:
        r101 = ThumbGlideUrl.SOURCE_VC;
        goto L24
    L12:
        r101 = IOfflineExtraParser.ParserType.TODO;
        goto L24
    L13:
        r101 = "security_compliance";
        goto L24
    L14:
        r101 = "search";
        goto L24
    L15:
        r101 = "open_platform";
        goto L24
    L16:
        r101 = TaskType.MEEGO_TASK;
        goto L24
    L17:
        r101 = IOfflineExtraParser.ParserType.MAIL;
        goto L24
    L18:
        r101 = "infra";
        goto L24
    L19:
        r101 = "ka";
        goto L24
    L20:
        r101 = "IM";
        goto L24
    L21:
        r101 = "CORE";
        goto L24
    L22:
        r101 = "Passport";
        goto L24
    }
}
