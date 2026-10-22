package jq1;

import com.bytedance.android.live.base.model.message.j0;
import com.bytedance.android.live.base.model.message.o1;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f500018a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f500019a = null;

        public a() {
        }

        static {
            f500019a = new a();
        }
    }

    /* JADX INFO: renamed from: jq1.b$b, reason: collision with other inner class name */
    public static final class C6474b {
        public static String a(b r100) {
            List<String> r101 = r100.b();
            if (r101 != null) goto L5;
        L8:
            return null;
        L5:
            if (r101.isEmpty() == true) goto L8;
            return r101.toString();
        }

        public static String b(b r100) {
            if (r100.a() == false) goto L6;
            return "official";
        L6:
            if (r100.getMedal() == null) goto L8;
            return "medal";
        L8:
            o1 r101 = r100.getLandscapeAreaCommon();
            if (r101 != null) goto L11;
        L13:
            return "normal";
        L11:
            if (r101.isStarMessage() != true) goto L13;
            return ScoreTags.SCORE_TYPE_STAR;
        }

        public static boolean c(b r100) {
            if (r100.getAgreeMsgId() != 0) goto L5;
        L7:
            return false;
        L5:
            if (r100.getAgreeMsgId() == r100.getMessageId()) goto L7;
            return true;
        }

        public static boolean d(b r100) {
            if (r100.isSelfSendFake() == false) goto L5;
        L8:
            return true;
        L5:
            if (r100.a() == true) goto L8;
            return false;
        }
    }

    static {
        f500018a = a.f500019a;
    }

    boolean a();

    List<String> b();

    String c();

    String d();

    String e();

    boolean f();

    boolean g();

    long getAgreeMsgId();

    CharSequence getChatContent();

    o1 getLandscapeAreaCommon();

    j0 getMedal();

    long getMessageId();

    IBaseUser getUserInfo();

    String h();

    k i();

    boolean isSelfSendFake();
}
