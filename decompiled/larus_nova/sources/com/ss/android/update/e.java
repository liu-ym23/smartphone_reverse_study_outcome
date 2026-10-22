package com.ss.android.update;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.larus.nova.R;
import java.lang.ref.WeakReference;
import yhc.f0;
import yhc.h;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UpdateServiceImpl f455322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IUpdateConfig f455323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f455324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f455325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f455326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f455327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f455329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f455330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference<h> f455331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final WeakHandler f455332k;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    public e() {
        this.f455326e = -1;
        this.f455332k = new WeakHandler(Looper.getMainLooper(), this);
        this.f455322a = f0.f567693b;
    }

    public final void b(int r100) {
        IUpdateConfig r101 = f0.f567692a;
        this.f455323b = r101;
        yhc.d r102 = r101.getUpdateConfig().f567742f;
        if (r102 == null) goto L24;
        WeakReference<Activity> r103 = r102.getCurrentActivity();
        if (r103 != null) goto L7;
        return;
    L7:
        Activity r104 = r103.get();
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.isFinishing() == false) goto L13;
        return;
    L13:
        if (r100 != (-2)) goto L15;
        a(r104, -2, R.string.check_dialog_none_title);
        return;
    L15:
        if (r100 != (-1)) goto L17;
        a(r104, -1, R.string.check_dialog_error_title);
        return;
    L17:
        if (r100 != 1) goto L29;
        this.f455322a.showUpdateDialog(1, r104, false);
        return;
    L29:
        return;
    L24:
        throw new IllegalArgumentException("iCurrentActivityCallback can not null");
    }

    public final void a(Activity r100, int r101, int r102) {
        WeakReference<h> r103 = this.f455331j;
        if (r103 == null) goto L10;
        h r104 = r103.get();
        if (r104 != null) goto L7;
        hta.d.a r105 = new hta.d.a(r100);
        hta.b.C6195b r106 = r105.f487190a;
        r106.f487180b = r106.f487179a.getText(r102);
        hta.b.C6195b r107 = r105.f487190a;
        r107.f487181c = r107.f487179a.getText(R.string.check_dialog_none_message);
        hta.b.C6195b r108 = r105.f487190a;
        r108.f487182d = r108.f487179a.getText(R.string.check_dialog_confirm);
        r105.f487190a.f487183e = null;
        r105.a();
        return;
    L7:
        if (r104.b() == true) goto L12;
        r104.a(r101);
        return;
    L12:
        return;
    L10:
        hta.d.a r109 = new hta.d.a(r100);
        hta.b.C6195b r110 = r109.f487190a;
        r110.f487180b = r110.f487179a.getText(r102);
        hta.b.C6195b r111 = r109.f487190a;
        r111.f487181c = r111.f487179a.getText(R.string.check_dialog_none_message);
        hta.b.C6195b r112 = r109.f487190a;
        r112.f487182d = r112.f487179a.getText(R.string.check_dialog_confirm);
        r109.f487190a.f487183e = null;
        r109.a();
    }
}
