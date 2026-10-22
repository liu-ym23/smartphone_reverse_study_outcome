package org.aspectj.lang.reflect;

/* JADX INFO: loaded from: classes42.dex */
public class NoSuchAdviceException extends Exception {
    private static final long serialVersionUID = 3256444698657634352L;
    private String name;

    public String getName() {
        return this.name;
    }

    public NoSuchAdviceException(String r100) {
        this.name = r100;
    }
}
