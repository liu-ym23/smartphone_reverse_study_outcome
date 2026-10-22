package com.lynx.clay.embedding.engine.plugins.audio.soundpool;

import android.content.Context;
import com.larus.media.MediaScene;

/* JADX INFO: loaded from: classes32.dex */
public interface GenericSoundPool {

    public static abstract enum Types extends Enum<Types> {
        public static final Types COMPACT = null;
        public static final Types SYSTEM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Types[] f380782a = null;

        public Types() {
            throw null;
        }

        public abstract GenericSoundPool create(Context r100);

        static {
            final String r100 = MediaScene.SYSTEM;
            final int r101 = 0;
            Types r102 = new AnonymousClass1(r100, r101);
            SYSTEM = r102;
            final String r103 = "COMPACT";
            final int r104 = 1;
            Types r105 = new AnonymousClass2(r103, r104);
            COMPACT = r105;
            f380782a = new Types[]{r102, r105};
        }

        public static Types[] values() {
            return (Types[]) f380782a.clone();
        }

        public static Types valueOf(String r100) {
            return (Types) r27.a.a(Types.class, r100);
        }

        public Types(String r100, int r101, a r102) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public interface b {
    }

    void a();

    void b(com.lynx.clay.embedding.engine.plugins.audio.a.C4547a r100);

    void c(int r100, int r101);

    int d(int r100, float r101, float r102, int r103);

    void e(int r100, float r101, float r102);

    void f();

    int load(String r100);

    void pause(int r100);

    void release();

    void resume(int r100);

    void stop(int r100);
}
