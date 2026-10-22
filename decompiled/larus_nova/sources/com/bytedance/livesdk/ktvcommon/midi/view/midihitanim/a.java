package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3638a f256096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C3638a f256097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f256098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f256099d;

    /* JADX INFO: renamed from: com.bytedance.livesdk.ktvcommon.midi.view.midihitanim.a$a, reason: collision with other inner class name */
    public static final class C3638a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ImageView> f256100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<ImageView> f256101b;

        public final boolean a() {
            if ((!this.f256100a.isEmpty()) == false) goto L5;
            return true;
        L5:
            if (((ArrayList) this.f256101b).size() < (((ArrayList) this.f256100a).size() + ((ArrayList) this.f256101b).size())) goto L10;
            return false;
        L10:
            return true;
        }

        public final ImageView b() {
            Iterator<T> r100 = this.f256100a.iterator();
        L4:
            if (r100.hasNext() == false) goto L9;
            ImageView r101 = (ImageView) r100.next();
            if (r101.getVisibility() != 4) goto L4;
            r101.setVisibility(0);
            ((ArrayList) this.f256101b).add(r101);
            return r101;
        L9:
            return null;
        }

        public C3638a() {
            this.f256100a = new ArrayList();
            this.f256101b = new ArrayList();
        }

        public final void c(ImageView r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            if (((ArrayList) this.f256101b).remove(r100) == true) goto L5;
        L7:
            r100.setVisibility(4);
            return;
        L5:
            if (((ArrayList) this.f256100a).contains(r100) == true) goto L7;
            ((ArrayList) this.f256100a).add(r100);
            goto L7
        }
    }

    public a(ViewGroup r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "config");
        this.f256098c = r100;
        this.f256099d = r101;
        this.f256096a = new C3638a();
        this.f256097b = new C3638a();
    }

    public final void a(C3638a r100, int r101) {
        int r102 = this.f256099d.f256110h;
        ViewGroup.LayoutParams r103 = new ViewGroup.LayoutParams(r102, r102);
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        ImageView r105 = new ImageView(this.f256098c.getContext());
        r105.setVisibility(4);
        this.f256098c.addView(r105, r103);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r105, "view");
        ((ArrayList) r100.f256100a).add(r105);
        r104 = r104 + 1;
        goto L3
    }
}
