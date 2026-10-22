package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.puretext.PureTextView;
import mp5.c;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f240351c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f240352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f240353b;

    public interface a {
    }

    public interface b {
    }

    public SpaceTextView(Context r100) {
        super(r100);
        this.f240352a = null;
    }

    @Override // android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908321) goto L5;
    L10:
        a r101 = this.f240352a;
        if (r101 == null) goto L31;
        PureTextView.b r102 = ((com.bytedance.ee.bear.drive.view.preview.puretext.a) r101).f225173a;
        r102.getClass();
        EncryptData r103 = r102.f225170b.f225159h;     // Catch: Throwable -> L20
        if (r103 != null) goto L16;
    L18:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L20
    L33:
    L26:
        b r104 = this.f240353b;
        if (r104 == null) goto L30;
        ((PureTextView) r104).f(r100);
    L30:
        return super.onTextContextMenuItem(r100);
    L16:
        if (r103.isBlock() == false) goto L18;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).j(r102.f225170b.f225159h.getEncryptId());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.e("PureTextView", AppConstants.API_HOST_SI_PREFIX, th, false);
        goto L26
    L31:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        tt5.a.e("SpaceTextView", AppConstants.API_HOST_SI_PREFIX, th, false);
        goto L26
    L5:
        if (r100 == 16908320) goto L10;
        if (r100 == 16908322) goto L10;
        if (r100 != 16908337) goto L26;
        goto L10
    }

    public void setCopyCallback(a r100) {
        this.f240352a = r100;
    }

    public void setOnTextContextMenuItemClickListener(b r100) {
        this.f240353b = r100;
    }

    public SpaceTextView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f240352a = null;
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).q(super.startActionMode(r100, r101), new c());
    }

    public SpaceTextView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f240352a = null;
    }
}
