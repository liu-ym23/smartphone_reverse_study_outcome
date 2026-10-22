package fu5;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.ActionMode;
import com.bytedance.ee.bear.sheet.cellcontent.view.SheetCellContentView;
import com.bytedance.supervisor.token.Token;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void a(String r100);

    boolean b();

    void c();

    void d(ClipboardManager.OnPrimaryClipChangedListener r100);

    void e(ClipboardManager.OnPrimaryClipChangedListener r100);

    Boolean f();

    boolean g(String r100, ClipData r101, boolean r102, Token r103);

    boolean h(ClipData r100, Token r101);

    void i();

    void j(String r100);

    ClipData k(String r100, Token r101);

    ClipData l(Token r100);

    boolean m(ClipData r100, boolean r101, Token r102);

    boolean n(String r100, boolean r101, Token r102);

    boolean o();

    boolean p(String r100, Token r101);

    ActionMode q(ActionMode r100, Function0<Boolean> r101);

    ActionMode.Callback r(ActionMode.Callback r100);

    boolean s();

    ActionMode.Callback t(Function0<Boolean> r100);

    boolean u(SheetCellContentView r100, Token r101);

    boolean v(Context r100, Intent r101);

    boolean w(String r100);
}
