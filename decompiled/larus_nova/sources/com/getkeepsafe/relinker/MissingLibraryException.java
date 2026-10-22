package com.getkeepsafe.relinker;

import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public class MissingLibraryException extends RuntimeException {
    public MissingLibraryException(String r100, String[] r101, String[] r102) {
        super("Could not find '" + r100 + "'. Looked for: " + Arrays.toString(r101) + ", but only found: " + Arrays.toString(r102) + ".");
    }
}
