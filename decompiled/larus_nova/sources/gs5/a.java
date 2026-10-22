package gs5;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements SharedPreferences {

    /* JADX INFO: renamed from: gs5.a$a, reason: collision with other inner class name */
    public class SharedPreferencesEditorC6063a implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return false;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            return this;
        }

        public SharedPreferencesEditorC6063a() {
        }
    }

    public a() {
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        return false;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC6063a();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return new HashMap();
    }
}
