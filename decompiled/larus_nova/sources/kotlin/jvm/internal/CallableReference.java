package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;

/* JADX INFO: loaded from: classes.dex */
public abstract class CallableReference implements KCallable, Serializable {
    public static final Object NO_RECEIVER = null;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    public static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = null;

        private NoReceiver() {
        }

        static {
            INSTANCE = new NoReceiver();
        }

        public static /* synthetic */ NoReceiver access$000() {
            return INSTANCE;
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public abstract KCallable computeReflected();

    public CallableReference() {
        this(NO_RECEIVER);
    }

    public KCallable compute() {
        KCallable r100 = this.reflected;
        if (r100 != null) goto L6;
        KCallable r101 = computeReflected();
        this.reflected = r101;
        return r101;
    L6:
        return r100;
    }

    public KDeclarationContainer getOwner() {
        Class r100 = this.owner;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.isTopLevel == false) goto L9;
        return Reflection.getOrCreateKotlinPackage(r100);
    L9:
        return Reflection.getOrCreateKotlinClass(r100);
    }

    static {
        NO_RECEIVER = NoReceiver.access$000();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override // kotlin.reflect.KCallable
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    public KCallable getReflected() {
        KCallable r100 = compute();
        if (r100 == this) goto L6;
        return r100;
    L6:
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KCallable
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    @Override // kotlin.reflect.KCallable
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.KCallable
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    public CallableReference(Object r100) {
        this(r100, null, null, null, false);
    }

    @Override // kotlin.reflect.KCallable
    public Object call(Object... r100) {
        return getReflected().call(r100);
    }

    @Override // kotlin.reflect.KCallable
    public Object callBy(Map r100) {
        return getReflected().callBy(r100);
    }

    public CallableReference(Object r100, Class r101, String r102, String r103, boolean r104) {
        this.receiver = r100;
        this.owner = r101;
        this.name = r102;
        this.signature = r103;
        this.isTopLevel = r104;
    }
}
