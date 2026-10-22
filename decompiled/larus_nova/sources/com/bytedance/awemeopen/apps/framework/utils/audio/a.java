package com.bytedance.awemeopen.apps.framework.utils.audio;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f197670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f197671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<InterfaceC2833a> f197672c;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.utils.audio.a$a, reason: collision with other inner class name */
    public interface InterfaceC2833a {
        void a();

        void b();

        void c(boolean r100);

        void d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void a() {
        this.f197670a = true;
        Iterator<T> r100 = this.f197672c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((InterfaceC2833a) r100.next()).a();
        goto L4
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void b() {
        this.f197671b = false;
        Iterator<T> r100 = this.f197672c.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((InterfaceC2833a) r100.next()).c(true);
        goto L4
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void c() {
        if (this.f197670a == true) goto L8;
        Iterator<T> r100 = this.f197672c.iterator();
    L6:
        if (r100.hasNext() == false) goto L12;
        ((InterfaceC2833a) r100.next()).d();
        goto L6
    L12:
        return;
    L8:
        Iterator<T> r101 = this.f197672c.iterator();
    L10:
        if (r101.hasNext() == false) goto L15;
        ((InterfaceC2833a) r101.next()).b();
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void d() {
        JSONObject r100 = AoSettings.a("ao_audio_focus_config");
        if (r100 == null) goto L5;
        boolean r101 = r100.optBoolean("need_pause_when_loss_transient");
    L6:
        this.f197670a = !r101;
        Iterator r102 = ((ArrayList) this.f197672c).iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        InterfaceC2833a r103 = (InterfaceC2833a) r102.next();
        if (r101 == true) goto L11;
        r103.a();
        goto L8
    L11:
        r103.c(false);
        goto L8
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public a() {
        this.f197672c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [com.bytedance.awemeopen.apps.framework.utils.audio.b] */
    public final void e(Function1<? super Boolean, Unit> r100) {
        if (this.f197671b == true) goto L23;
        this.f197671b = true;
        AudioManager r101 = c.f197673a;
        Application r102 = y54.a.a();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "listener");
        c.f197675c = this;
        if (c.f197673a != null) goto L8;
        c.f197673a = (AudioManager) r102.getSystemService("audio");
    L8:
        if (c.f197674b != null) goto L11;
        c.f197674b = new b();
    L11:
        if (c.f197673a != null) goto L14;
        int r103 = 0;
    L20:
        if (r103 == 1) goto L22;
        this.f197671b = false;
        r100.invoke(Boolean.FALSE);
        return;
    L22:
        r100.invoke(Boolean.TRUE);
        return;
    L14:
        if (Build.VERSION.SDK_INT >= 26) goto L16;
        AudioManager r104 = c.f197673a;
        Intrinsics.checkNotNull(r104);
        r103 = r104.requestAudioFocus(c.f197674b, 3, 1);
        goto L20
    L16:
        if (c.f197676d != null) goto L18;
        AudioFocusRequest.Builder r105 = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(true);
        b r106 = c.f197674b;
        Intrinsics.checkNotNull(r106);
        c.f197676d = r105.setOnAudioFocusChangeListener(r106).build();
    L18:
        AudioManager r107 = c.f197673a;
        Intrinsics.checkNotNull(r107);
        AudioFocusRequest r108 = c.f197676d;
        Intrinsics.checkNotNull(r108);
        r103 = r107.requestAudioFocus(r108);
        goto L20
    L23:
        r100.invoke(Boolean.TRUE);
    }
}
