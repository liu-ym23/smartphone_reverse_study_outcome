package com.larus.voicecall.impl.component.scene;

import androidx.lifecycle.LiveData;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.scene.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import l3a.c;

/* JADX INFO: loaded from: classes32.dex */
public interface a extends t1a.a {
    public static final C4526a C1 = null;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.scene.a$a, reason: collision with other inner class name */
    public static final class C4526a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C4526a f377651a = null;

        static {
            f377651a = new C4526a();
        }

        public C4526a() {
        }

        public static boolean a(SceneModel r100) {
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == true) goto L15;
            if (r100 != null) goto L11;
        L13:
            boolean r102 = false;
        L14:
            if (r102 == true) goto L15;
            return false;
        L11:
            if (r100.getId() != 20) goto L13;
            r102 = true;
        L15:
            return true;
        L5:
            if (r100.getId() != 21) goto L7;
            r101 = true;
            goto L8
        }
    }

    public static final class b {
        public static /* synthetic */ void a(a r100, boolean r101, int r102) {
            Function0<Unit> r103 = null;
            if ((r102 & 1) == 0) goto L5;
            Function0<Unit> r104 = new l3a.a();
        L7:
            if ((r102 & 2) == 0) goto L10;
            r103 = new l3a.b();
        L10:
            if ((r102 & 4) == 0) goto L12;
            r101 = false;
        L12:
            r100.x50(r104, r103, r101);
            return;
        L5:
            r104 = null;
            goto L7
        }
    }

    static {
        C1 = C4526a.f377651a;
    }

    void Fk(c r100);

    void Ii(String r100);

    void R3(m r100, int r101);

    void bQ();

    LiveData<m> getCurrentScene();

    List<m> getSceneList();

    boolean oY();

    boolean wm();

    void x50(Function0<Unit> r100, Function0<Unit> r101, boolean r102);

    void yM(c r100);
}
