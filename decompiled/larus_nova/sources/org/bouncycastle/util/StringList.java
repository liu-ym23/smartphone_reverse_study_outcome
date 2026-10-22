package org.bouncycastle.util;

/* JADX INFO: loaded from: classes42.dex */
public interface StringList extends Iterable<String> {
    boolean add(String r100);

    String get(int r100);

    int size();

    String[] toStringArray();

    String[] toStringArray(int r100, int r101);
}
