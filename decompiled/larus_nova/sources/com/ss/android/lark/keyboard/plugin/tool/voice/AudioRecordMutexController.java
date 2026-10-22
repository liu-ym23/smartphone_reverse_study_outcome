package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.media.MediaMutex;
import com.ss.android.lark.media.MediaType;
import com.ss.android.lark.media.Scene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioRecordMutexController {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<AudioRecordMutexController> f429805d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f429806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<b> f429807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f429808c;

    public static final class a {
        @JvmStatic
        public static AudioRecordMutexController a() {
            return AudioRecordMutexController.f429805d.getValue();
        }
    }

    public interface b {
        void a(Scene r100, MediaType r101);
    }

    public interface c {

        public static final class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final MediaMutex.LockError f429809a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f429809a, ((a) r100).f429809a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f429809a.hashCode();
            }

            public final String toString() {
                return "Error(lockError=" + this.f429809a + ')';
            }

            public a(MediaMutex.LockError r100) {
                Intrinsics.checkNotNullParameter(r100, "lockError");
                this.f429809a = r100;
            }
        }

        public static final class b implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Scene f429810a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final MediaType f429811b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f429812c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (this.f429810a == r101.f429810a) goto L12;
                return false;
            L12:
                if (this.f429811b == r101.f429811b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f429812c, r101.f429812c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = ((this.f429810a.hashCode() * 31) + this.f429811b.hashCode()) * 31;
                String r101 = this.f429812c;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Interrupted(byScene=" + this.f429810a + ", type=" + this.f429811b + ", interruptMsg=" + this.f429812c + ')';
            }

            public final MediaType getType() {
                return this.f429811b;
            }

            public b(Scene r100, MediaType r101) {
                Intrinsics.checkNotNullParameter(r100, "byScene");
                Intrinsics.checkNotNullParameter(r101, "type");
                this.f429810a = r100;
                this.f429811b = r101;
                this.f429812c = "";
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController$c$c, reason: collision with other inner class name */
        public static final class C5107c implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5107c f429813a = null;

            static {
                f429813a = new C5107c();
            }

            public C5107c() {
            }
        }
    }

    public static final class d implements com.ss.android.lark.media.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioRecordMutexController f429814a;

        @Override // com.ss.android.lark.media.a
        public final void onSuccess() {
            AudioRecordMutexController r100 = this.f429814a;
            r100.f429806a = c.C5107c.f429813a;
        }

        public d(AudioRecordMutexController r100) {
            this.f429814a = r100;
        }

        @Override // com.ss.android.lark.media.a
        public final void a(MediaMutex.LockError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            Log.w("AudioRecordMutexController", "media is occupied, scene:" + r100.getOccupiedScene());
            this.f429814a.f429806a = new c.a(r100);
        }

        @Override // com.ss.android.lark.media.a
        public final void b(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "byScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            Log.i("AudioRecordMutexController", "Interrupted byScene:" + r100 + ",type:" + r101 + ",interruptMsg:");
            this.f429814a.f429806a = new c.b(r100, r101);
            Iterator<b> r102 = this.f429814a.f429807b.iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            r102.next().a(r100, r101);
            goto L4
        }

        @Override // com.ss.android.lark.media.a
        public final void c(Scene r100, MediaType r101) {
            Intrinsics.checkNotNullParameter(r100, "fromScene");
            Intrinsics.checkNotNullParameter(r101, "type");
            Log.i("AudioRecordMutexController", "InterruptionEnd fromScene:" + r100 + ",type:" + r101);
        }
    }

    static {
        f429805d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AudioRecordMutexController$Companion$sInstance$2.INSTANCE);
    }

    public AudioRecordMutexController() {
        this.f429807b = new CopyOnWriteArraySet();
        this.f429808c = new d(this);
    }

    public static void a(AudioRecordMutexController r100) {
        Scene r101 = Scene.IM_Audio_Record;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "scene");
        if ((r100.f429806a instanceof c.C5107c) == false) goto L7;
        r100.f429806a = null;
        MediaMutex.f431631r.n(r101, r100.f429808c);
        return;
    }

    public static boolean b(AudioRecordMutexController r100, Context r101) {
        Scene r102 = Scene.IM_Audio_Record;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "scene");
        boolean r103 = true;
        if ((r100.f429806a instanceof c.C5107c) == false) goto L5;
        Log.i("AudioRecordMutexController", "tryOccupyResource status already Occupied");
        return true;
    L5:
        MediaMutex.f431631r.getClass();
        Log.i("AudioRecordMutexController", "tryOccupyResource tryLock");
        MediaMutex.f431631r.l(r102, true, r100.f429808c, true);
        c r104 = r100.f429806a;
        if ((r104 instanceof c.a) == false) goto L15;
        c.a r105 = (c.a) r104;
        String r106 = r105.f429809a.getErrorMessage();
        if (r106.length() > 0) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        new UDDialogBuilder(r101).message(r106).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_Confirm, null).show();
    L25:
        return false;
    L13:
        Log.w("AudioRecordMutexController", "err but no msg", r105.f429809a);
        goto L25
    L15:
        if ((r104 instanceof c.b) == false) goto L26;
        c.b r107 = (c.b) r104;
        String r108 = r107.f429812c;
        if (r108 != null) goto L19;
    L22:
        if (r103 == false) goto L24;
        Log.w("AudioRecordMutexController", "Interrupted but no msg,byScene:" + r104 + ".byScene,type:" + r104 + ".type");
        goto L25
    L24:
        new UDDialogBuilder(r101).message(r107.f429812c).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_Confirm, null).show();
        goto L25
    L19:
        if (r108.length() == 0) goto L22;
        r103 = false;
        goto L22
    L26:
        Log.i("AudioRecordMutexController", "tryOccupyResource tryLock status:" + r104 + ",isOccupied:" + (r104 instanceof c.C5107c));
        return true;
    }
}
