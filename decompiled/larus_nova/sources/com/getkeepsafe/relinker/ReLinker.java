package com.getkeepsafe.relinker;

import android.content.Context;

/* JADX INFO: loaded from: classes23.dex */
public class ReLinker {

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    private ReLinker() {
    }

    public static com.getkeepsafe.relinker.b force() {
        com.getkeepsafe.relinker.b r100 = new com.getkeepsafe.relinker.b();
        r100.f274236d = true;
        return r100;
    }

    public static com.getkeepsafe.relinker.b recursively() {
        com.getkeepsafe.relinker.b r100 = new com.getkeepsafe.relinker.b();
        r100.f274237e = true;
        return r100;
    }

    public static com.getkeepsafe.relinker.b log(d r100) {
        return new com.getkeepsafe.relinker.b();
    }

    public static void loadLibrary(Context r100, String r101) {
        loadLibrary(r100, r101, null, null);
    }

    public static void loadLibrary(Context r100, String r101, c r102) {
        loadLibrary(r100, r101, null, r102);
    }

    public static void loadLibrary(Context r100, String r101, String r102) {
        loadLibrary(r100, r101, r102, null);
    }

    public static void loadLibrary(Context r100, String r101, String r102, c r103) {
        new com.getkeepsafe.relinker.b().b(r100, r101, r102);
    }
}
