package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes42.dex */
public interface SourceFile {
    public static final SourceFile NO_SOURCE_FILE = null;

    String getName();

    static {
        NO_SOURCE_FILE = new AnonymousClass1();
    }
}
