package com.bytedance.keva;

import android.content.Context;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class Keva {

    public interface ClearMemory {
        void clearMemory(int r100);
    }

    public interface OnChangeListener {
        void onChanged(Keva r100, String r101);
    }

    public Keva() {
    }

    public abstract Map<String, Object> buildNewMap(Map<String, Object> r100);

    public abstract void clear();

    public abstract boolean contains(String r100);

    public abstract int count();

    public abstract void dump();

    public abstract void erase(String r100);

    public abstract Map<String, ?> getAll();

    public abstract boolean getBoolean(String r100, boolean r101);

    public abstract byte[] getBytes(String r100, byte[] r101);

    public abstract byte[] getBytesJustDisk(String r100, byte[] r101);

    public abstract double getDouble(String r100, double r101);

    public abstract float getFloat(String r100, float r101);

    public abstract int getInt(String r100, int r101);

    public abstract long getLong(String r100, long r101);

    public abstract String getString(String r100, String r101);

    public abstract String[] getStringArray(String r100, String[] r101);

    public abstract String[] getStringArrayJustDisk(String r100, String[] r101);

    public abstract String getStringJustDisk(String r100, String r101);

    public abstract Set<String> getStringSet(String r100, Set<String> r101);

    public abstract Set<String> getStringSetJustDisk(String r100, Set<String> r101);

    public abstract String name();

    public abstract void registerChangeListener(OnChangeListener r100);

    public abstract void storeBoolean(String r100, boolean r101);

    public abstract void storeBytes(String r100, byte[] r101);

    public abstract void storeBytesJustDisk(String r100, byte[] r101);

    public abstract void storeDouble(String r100, double r101);

    public abstract void storeFloat(String r100, float r101);

    public abstract void storeInt(String r100, int r101);

    public abstract void storeLong(String r100, long r101);

    public abstract void storeString(String r100, String r101);

    public abstract void storeStringArray(String r100, String[] r101);

    public abstract void storeStringArrayJustDisk(String r100, String[] r101);

    public abstract void storeStringJustDisk(String r100, String r101);

    public abstract void storeStringSet(String r100, Set<String> r101);

    public abstract void storeStringSetJustDisk(String r100, Set<String> r101);

    public abstract void unRegisterChangeListener(OnChangeListener r100);

    public static int clearIdleRepoMemory() {
        return KevaImpl.clearIdleRepoMemory();
    }

    public static void forceInit() {
        KevaImpl.forceInitImpl();
    }

    public static void markPreloadDone() {
        KevaImpl.markPreloadDone();
    }

    public static void clearOnLowMemory(int r100) {
        KevaImpl.clearOnLowMemory(r100);
    }

    public static Keva getRepo(String r100) {
        return KevaImpl.getRepo(r100, 0);
    }

    public static boolean isRepoPorted(String r100) {
        return KevaImpl.isRepoPorted(r100);
    }

    public static Keva getRepo(String r100, int r101) {
        return KevaImpl.getRepo(r100, r101);
    }

    public static Keva getRepoSync(String r100, int r101) {
        return KevaImpl.getRepoSync(r100, r101);
    }

    public static Keva getRepoFromSp(Context r100, String r101, int r102) {
        return KevaImpl.getRepoFromSp(r100, r101, r102);
    }

    public static Keva getRepoFromSpSync(Context r100, String r101, int r102) {
        return KevaImpl.getRepoFromSpSync(r100, r101, r102);
    }

    public static Keva getRepoSyncWithPath(String r100, String r101, int r102) {
        return KevaImpl.getRepoSyncWithPath(r100, r101, r102);
    }
}
