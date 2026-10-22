package ke8;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController;
import com.larus.platform.api.creation.TplType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class z implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UplinkTextMenuController f503106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f503107b;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        final UplinkTextMenuController r101 = this.f503106a;
        if (r101.f302063l != r100) goto L6;
        r101.f302063l = null;
        TextView r102 = r101.f302052a;
        final int r103 = this.f503107b;
        r102.post(new y(r101, r103));
        return;
    }

    public z(UplinkTextMenuController r100, int r101) {
        this.f503106a = r100;
        this.f503107b = r101;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (this.f503106a.b(this.f503107b) == true) goto L7;
        r100.finish();
        return true;
    L7:
        if (r101.getItemId() == 16908321) goto L10;
        return false;
    L10:
        int r102 = Math.min(this.f503106a.f302052a.getSelectionStart(), this.f503106a.f302052a.getSelectionEnd());
        int r103 = Math.max(this.f503106a.f302052a.getSelectionStart(), this.f503106a.f302052a.getSelectionEnd());
        if (r102 < 0) goto L22;
        if (r103 <= r102) goto L22;
        if (r103 > this.f503106a.f302052a.getText().length()) goto L22;
        UplinkTextMenuController r104 = this.f503106a;
        CharSequence r105 = r104.f302052a.getText().subSequence(r102, r103);
        if (r102 == 0) goto L18;
    L20:
        String r106 = "part";
    L21:
        r104.c(r105, r106);
        goto L22
    L18:
        if (r103 != this.f503106a.f302052a.getText().length()) goto L20;
        r106 = "all";
    L22:
        r100.finish();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        if (this.f503106a.b(this.f503107b) == true) goto L6;
        return false;
    L6:
        UplinkTextMenuController r102 = this.f503106a;
        r102.f302063l = r100;
        UplinkTextMenuController.a(r102, r101);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        if (this.f503106a.b(this.f503107b) == true) goto L6;
        r100.finish();
        return false;
    L6:
        UplinkTextMenuController.a(this.f503106a, r101);
        return true;
    }
}
