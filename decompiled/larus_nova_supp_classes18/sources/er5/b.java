package er5;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.workspace.NewBaseEntry;
import com.bytedance.ee.bear.workspace.NewBaseType;
import com.bytedance.ee.bear.workspace.WorkspaceAction;
import io.reactivex.Flowable;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r5, Context r6, WorkspaceAction r7, String r8, String r9, d r10, e r11, NewBaseType r12, NewBaseEntry r13, int r14) {
            NewBaseEntry r2 = null;
            if ((r14 & 4) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r14 & 8) == 0) goto L9;
            String r3 = null;
        L11:
            if ((r14 & 64) == 0) goto L13;
            NewBaseType r4 = null;
        L15:
            if ((r14 & 128) != 0) goto L18;
            r2 = r13;
        L18:
            r5.e(r6, r7, r1, r3, r4, r2);
            return;
        L13:
            r4 = r12;
            goto L15
        L9:
            r3 = r9;
            goto L11
        L5:
            r1 = r8;
            goto L7
        }
    }

    void a(Map r1);

    void b(Context r1, String r2, Function0<Unit> r3);

    void c(WorkspaceAction r1, String r2, Function1<? super String, Unit> r3);

    void d(String r1, Function1<? super h, Unit> r2);

    void e(Context r1, WorkspaceAction r2, String r3, String r4, NewBaseType r5, NewBaseEntry r6);

    void f(Context r1, String r2, Function0<Unit> r3);

    String g(Fragment r1);

    void h(Context r1, String r2, String r3);

    void i();

    boolean j();

    Flowable<DocumentCreateInfo> k(er5.a r1);
}
