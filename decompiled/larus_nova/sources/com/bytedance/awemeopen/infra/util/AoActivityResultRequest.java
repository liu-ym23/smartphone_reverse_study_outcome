package com.bytedance.awemeopen.infra.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes46.dex */
public final class AoActivityResultRequest {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Handler f198941b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f198942a;

    public static class OnActivityResultFragment extends Fragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f198943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f198944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f198945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f198946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f198947e;

        public OnActivityResultFragment() {
            this.f198943a = new AtomicBoolean(false);
            this.f198947e = new AtomicBoolean(false);
        }

        @Override // android.app.Fragment
        public final void onAttach(Activity r100) {
            super.onAttach(r100);
            if (this.f198944b != null) goto L5;
            Activity r101 = getActivity();
            if (r101 == null) goto L23;
            r101.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        L23:
            return;
        L5:
            if (this.f198947e.getAndSet(true) == true) goto L19;
            setRetainInstance(true);
            startActivityForResult(this.f198944b, this.f198945c);     // Catch: ActivityNotFoundException -> L9
            return;
        L9:
            a r102 = this.f198946d;
            if (r102 == null) goto L20;
            com.bytedance.awemeopen.infra.util.a r103 = (com.bytedance.awemeopen.infra.util.a) r102;
            r103.a(this.f198945c, Integer.MIN_VALUE, null);
            return;
        L20:
            return;
        }

        @Override // android.app.Fragment
        public final void onActivityResult(int r100, int r101, Intent r102) {
            a r103 = this.f198946d;
            if (r103 == null) goto L5;
            ((com.bytedance.awemeopen.infra.util.a) r103).a(r100, r101, r102);
        L5:
            Activity r104 = getActivity();
            if (r104 == null) goto L10;
            r104.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
            return;
        }
    }

    public interface a {
    }

    public AoActivityResultRequest(Activity r100) {
        this.f198942a = r100;
    }
}
