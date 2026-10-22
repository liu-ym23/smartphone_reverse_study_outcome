package i34;

import android.app.Activity;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.share.e;
import com.bytedance.awemeopen.infra.support.AoThrowableResult;
import i24.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.c;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends k24.a {

    /* JADX INFO: renamed from: i34.a$a, reason: collision with other inner class name */
    public static final class C6222a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6222a) == true) goto L8;
            return false;
        L8:
            ((C6222a) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ShareInfo(desc=null, url=null)";
        }
    }

    void g2(c r100, Function1<? super AoThrowableResult<d>, Unit> r101);

    void h0(Activity r100, long r101, String r102, String r103, String r104, String r105, e r106, JSONObject r107, Function2 r110);

    boolean l();
}
