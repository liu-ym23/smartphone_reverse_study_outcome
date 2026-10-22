package com.lynx.textra;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public class JavaFontManager {
    private final AtomicInteger mCount;
    private final LinkedList<JavaTypeface> mFontList;
    private final LinkedHashMap<JavaTypeface.FontKey, JavaTypeface> mFontMap;
    private final long mNativeHandler;

    private native void BindNativeInstance(long r100, JavaFontManager r101);

    private native long CreateNativeTypeface(long r100);

    public long GetNativeHandler() {
        return this.mNativeHandler;
    }

    public JavaFontManager(long r100) {
        this.mCount = new AtomicInteger(0);
        this.mFontMap = new LinkedHashMap();
        this.mFontList = new LinkedList();
        this.mNativeHandler = r100;
    }

    public synchronized JavaTypeface GetTypefaceByIndex(int r100) {
        monitor-enter(this);
        Iterator<JavaTypeface> r101 = this.mFontMap.values().iterator();     // Catch: Throwable -> L20
    L5:
        if (r101.hasNext() == false) goto L10;
        JavaTypeface r102 = r101.next();     // Catch: Throwable -> L20
        if (r102.mIndex != r100) goto L5;
        monitor-exit(this);
        return r102;
    L10:
        Iterator<JavaTypeface> r103 = this.mFontList.iterator();     // Catch: Throwable -> L20
    L11:
        if (r103.hasNext() == false) goto L17;
        JavaTypeface r104 = r103.next();     // Catch: Throwable -> L20
        if (r104.mIndex != r100) goto L11;
        monitor-exit(this);
        return r104;
    L17:
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public long onMatchTypefaceIndex(long r100) {
        return GetTypefaceByIndex((int) r100).mNativeHandler;
    }

    public synchronized JavaTypeface RegisterShapeFont(Font r100, JavaTypeface.FontKey r101) {
        monitor-enter(this);
        JavaTypeface r102 = this.mFontMap.get(r101);     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = new JavaTypeface(this.mCount.incrementAndGet(), r100, r101, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L8
        this.mFontMap.put(r101, r102);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r102;
    L8:
        th = move-exception;
        throw th;
    }

    private synchronized JavaTypeface RegisterTypeface(Typeface r100, JavaTypeface.FontKey r101, long r110) {
        monitor-enter(this);
        JavaTypeface r102 = new JavaTypeface(this.mCount.incrementAndGet(), r100, r101, r110);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized JavaTypeface CreateOrRegisterTypeface(Typeface r100, String r101, int r102, boolean r103) {
        monitor-enter(this);
        JavaTypeface.FontKey r104 = new JavaTypeface.FontKey();     // Catch: Throwable -> L17
        if (r101 != null) goto L6;
    L8:
        r104.mFontWeight = r102;     // Catch: Throwable -> L17
        r104.mItalic = r103;     // Catch: Throwable -> L17
        JavaTypeface r105 = this.mFontMap.get(r104);     // Catch: Throwable -> L17
        if (r105 != null) goto L12;
        r105 = RegisterTypeface(r100, r104, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L17
    L14:
        this.mFontMap.put(r104, r105);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r105;
    L12:
        if (r105.mTypeface == r100) goto L14;
        this.mFontList.add(r105);     // Catch: Throwable -> L17
        r105 = RegisterTypeface(r100, r104, CreateNativeTypeface(this.mNativeHandler));     // Catch: Throwable -> L17
        goto L14
    L6:
        if (r101.isEmpty() == true) goto L8;
        r104.mFontFamily = r101;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized long onMatchFamilyStyle(String r100, int r101, boolean r102, long r103) {
        monitor-enter(this);
        JavaTypeface.FontKey r104 = new JavaTypeface.FontKey();     // Catch: Throwable -> L49
        if (r100 != null) goto L6;
    L8:
        r104.mFontWeight = r101;     // Catch: Throwable -> L49
        r104.mItalic = r102;     // Catch: Throwable -> L49
        JavaTypeface r105 = this.mFontMap.get(r104);     // Catch: Throwable -> L49
        if (r105 == null) goto L13;
        long r106 = r105.mNativeHandler;     // Catch: Throwable -> L49
        monitor-exit(this);
        return r106;
    L13:
        r104.mFontFamily = "";     // Catch: Throwable -> L49
        JavaTypeface r107 = this.mFontMap.get(r104);     // Catch: Throwable -> L49
        if (r107 == null) goto L19;
        long r108 = r107.mNativeHandler;     // Catch: Throwable -> L49
        monitor-exit(this);
        return r108;
    L19:
        if (r101 < 700) goto L22;
        if (r102 == false) goto L22;
        int r109 = 3;
    L27:
        long r110 = 0;
        JavaTypeface r111 = null;
        Typeface r112 = Typeface.create(Typeface.DEFAULT, r109);     // Catch: Exception -> L36 Throwable -> L49
        if (r112 != null) goto L31;
        r112 = Typeface.DEFAULT;     // Catch: Exception -> L36 Throwable -> L49
    L31:
        JavaTypeface r113 = RegisterTypeface(r112, r104, r103);     // Catch: Exception -> L36 Throwable -> L49
        if (r113.mNativeHandler == 0) goto L37;
        r111 = r113;
    L37:
        if (r111 == null) goto L40;
        this.mFontMap.put(r104, r111);     // Catch: Throwable -> L49
    L45:
        if (r111 == null) goto L47;
        r110 = r111.mNativeHandler;     // Catch: Throwable -> L49
    L47:
        monitor-exit(this);
        return r110;
    L40:
        if (this.mFontMap.isEmpty() == true) goto L43;
        r111 = this.mFontMap.values().iterator().next();     // Catch: Throwable -> L49
        goto L45
    L43:
        if (this.mFontList.isEmpty() == true) goto L45;
        r111 = this.mFontList.getFirst();     // Catch: Throwable -> L49
    L22:
        if (r101 < 700) goto L24;
        r109 = 1;
        goto L27
    L24:
        if (r102 == false) goto L26;
        r109 = 2;
        goto L27
    L26:
        r109 = 0;
        goto L27
    L6:
        if (r100.isEmpty() == true) goto L8;
        r104.mFontFamily = r100;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }
}
