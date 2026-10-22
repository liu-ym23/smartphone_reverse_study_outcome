package com.bytedance.awemeopen.apps.framework.utils.audio;

import android.app.Application;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements c.a {
    public boolean a;
    public boolean b;
    public final List<InterfaceC0106a> c;

    /* JADX INFO: renamed from: com.bytedance.awemeopen.apps.framework.utils.audio.a$a, reason: collision with other inner class name */
    public interface InterfaceC0106a {
        void a();

        void b();

        void c(boolean r1);

        void d();
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void a() {
        this.a = true;
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((InterfaceC0106a) r0.next()).a();
        goto L4
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void b() {
        this.b = false;
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((InterfaceC0106a) r0.next()).c(true);
        goto L4
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void c() {
        if (this.a == true) goto L8;
        Iterator<T> r0 = this.c.iterator();
    L6:
        if (r0.hasNext() == false) goto L12;
        ((InterfaceC0106a) r0.next()).d();
        goto L6
    L12:
        return;
    L8:
        Iterator<T> r1 = this.c.iterator();
    L10:
        if (r1.hasNext() == false) goto L15;
        ((InterfaceC0106a) r1.next()).b();
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.audio.c.a
    public final void d() {
        JSONObject r0 = AoSettings.a("ao_audio_focus_config");
        if (r0 == null) goto L5;
        boolean r1 = r0.optBoolean("need_pause_when_loss_transient");
    L6:
        this.a = !r1;
        Iterator r2 = ((ArrayList) this.c).iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        InterfaceC0106a r3 = (InterfaceC0106a) r2.next();
        if (r1 == true) goto L11;
        r3.a();
        goto L8
    L11:
        r3.c(false);
        goto L8
    L13:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public a() {
        this.c = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r1v18, types: [com.bytedance.awemeopen.apps.framework.utils.audio.b] */
    public final void e(Function1<? super Boolean, Unit> r6) {
        if (this.b == true) goto L23;
        this.b = true;
        AudioManager r1 = c.a;
        Application r2 = y54.a.a();
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(this, "listener");
        c.c = this;
        if (c.a != null) goto L8;
        c.a = (AudioManager) r2.getSystemService("audio");
    L8:
        if (c.b != null) goto L11;
        c.b = new b();
    L11:
        if (c.a != null) goto L14;
        int r3 = 0;
    L20:
        if (r3 == 1) goto L22;
        this.b = false;
        r6.invoke(Boolean.FALSE);
        return;
    L22:
        r6.invoke(Boolean.TRUE);
        return;
    L14:
        if (Build.VERSION.SDK_INT >= 26) goto L16;
        AudioManager r4 = c.a;
        Intrinsics.checkNotNull(r4);
        r3 = r4.requestAudioFocus(c.b, 3, 1);
        goto L20
    L16:
        if (c.d != null) goto L18;
        AudioFocusRequest.Builder r5 = new AudioFocusRequest.Builder(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(true).setWillPauseWhenDucked(true);
        b r7 = c.b;
        Intrinsics.checkNotNull(r7);
        c.d = r5.setOnAudioFocusChangeListener(r7).build();
    L18:
        AudioManager r8 = c.a;
        Intrinsics.checkNotNull(r8);
        AudioFocusRequest r9 = c.d;
        Intrinsics.checkNotNull(r9);
        r3 = r8.requestAudioFocus(r9);
        goto L20
    L23:
        r6.invoke(Boolean.TRUE);
    }
}
