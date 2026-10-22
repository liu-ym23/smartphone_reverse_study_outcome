package ng;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AudioManager f519014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AudioFocusRequest f519015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<WeakReference<ng.a>> f519016c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f519017d = null;

    public static final class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f519018a = null;

        static {
            f519018a = new a();
        }

        public a() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(int r100) {
            if (r100 != (-3)) goto L5;
        L22:
            Iterator r101 = ((ArrayList) b.f519016c).iterator();
        L24:
            if (r101.hasNext() == false) goto L28;
            ng.a r102 = (ng.a) ((WeakReference) r101.next()).get();
            if (r102 == null) goto L24;
            r102.b();
            goto L24
        L28:
            AudioManager r103 = b.f519014a;
            return;
        L5:
            if (r100 == (-2)) goto L22;
            if (r100 == (-1)) goto L22;
            if (r100 != 1) goto L11;
        L15:
            Iterator r104 = ((ArrayList) b.f519016c).iterator();
        L17:
            if (r104.hasNext() == false) goto L21;
            ng.a r105 = (ng.a) ((WeakReference) r104.next()).get();
            if (r105 == null) goto L17;
            r105.a();
            goto L17
        L21:
            AudioManager r106 = b.f519014a;
            return;
        L11:
            if (r100 == 2) goto L15;
            if (r100 == 3) goto L15;
        }
    }

    static {
        f519016c = new ArrayList();
        f519017d = a.f519018a;
    }
}
