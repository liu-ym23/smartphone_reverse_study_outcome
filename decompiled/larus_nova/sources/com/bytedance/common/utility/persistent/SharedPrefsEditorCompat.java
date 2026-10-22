package com.bytedance.common.utility.persistent;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public class SharedPrefsEditorCompat {
    static final EditorImpl IMPL = null;

    public interface EditorImpl {
        void apply(SharedPreferences.Editor r100);
    }

    public static class GingerbreadEditorImpl implements EditorImpl {
        public GingerbreadEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor r100) {
            r100.apply();
        }
    }

    static {
        IMPL = new GingerbreadEditorImpl();
    }

    public static void apply(SharedPreferences.Editor r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        IMPL.apply(r100);
    }
}
