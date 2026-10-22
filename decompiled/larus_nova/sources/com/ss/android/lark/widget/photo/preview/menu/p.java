package com.ss.android.lark.widget.photo.preview.menu;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f446974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f446975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f446976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f446977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PhotoItem f446978e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.ss.android.lark.widget.photo.preview.menu.action.m> f446979f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.ss.android.lark.widget.photo.preview.menu.action.o f446980g;

    public interface a {
        void a(PhotoItem r100, PhotoItem r101);

        void b(String r100, String r101, String r102, String r103, String r104);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f446981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f446982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f446983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f446984d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f446985e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f446986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f446987g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f446988h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f446989i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f446990j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> f446991k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f446992l;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f446993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f446994b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f446995c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f446996d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f446997e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f446998f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public boolean f446999g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public boolean f447000h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public boolean f447001i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f447002j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean f447003k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public ArrayList<Class<com.ss.android.lark.widget.photo.preview.menu.action.l>> f447004l;

            public a() {
                this.f446993a = false;
                this.f446994b = true;
                this.f446995c = false;
                this.f446996d = null;
                this.f446997e = true;
                this.f446998f = true;
                this.f446999g = false;
                this.f447000h = true;
                this.f447001i = false;
                this.f447002j = true;
                this.f447003k = false;
            }
        }

        public b(a r100) {
            this.f446981a = r100.f446993a;
            this.f446982b = r100.f446994b;
            this.f446983c = r100.f446995c;
            this.f446984d = r100.f446997e;
            this.f446985e = r100.f446998f;
            this.f446987g = r100.f446999g;
            this.f446988h = r100.f447002j;
            this.f446989i = r100.f447000h;
            this.f446990j = r100.f447001i;
            this.f446991k = r100.f447004l;
            this.f446986f = r100.f447003k;
            this.f446992l = r100.f446996d;
        }
    }

    public p(FragmentActivity r100, b r101) {
        this.f446976c = "";
        CopyOnWriteArrayList<com.ss.android.lark.widget.photo.preview.menu.action.m> r102 = new CopyOnWriteArrayList();
        this.f446979f = r102;
        this.f446974a = r100;
        this.f446975b = r101;
        this.f446980g = new com.ss.android.lark.widget.photo.preview.menu.action.o(r100, r101.f446989i, r102);
    }
}
