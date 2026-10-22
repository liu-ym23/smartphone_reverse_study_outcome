package kotlin.reflect.jvm.internal.impl.utils;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.SmartList$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = null;

        private EmptyIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        static {
            INSTANCE = new EmptyIterator();
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;
        final /* synthetic */ SmartList this$0;

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public void checkCoModification() {
            if (SmartList.access$300(this.this$0) != this.myInitialModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException("ModCount: " + SmartList.access$400(this.this$0) + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        public E getElement() {
            return (E) SmartList.access$200(this.this$0);
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            this.this$0.clear();
        }

        public SingletonIterator(SmartList r100) {
            this.this$0 = r100;
            super(null);
            this.myInitialModCount = SmartList.access$100(r100);
        }
    }

    /* JADX INFO: loaded from: classes42.dex */
    public static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        private SingletonIteratorBase() {
        }

        public abstract void checkCoModification();

        public abstract T getElement();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.myVisited == true) goto L7;
            this.myVisited = true;
            checkCoModification();
            return getElement();
        L7:
            throw new NoSuchElementException();
        }

        public /* synthetic */ SingletonIteratorBase(AnonymousClass1 r100) {
            this();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int r110) {
        if (r110 == 2) goto L9;
        if (r110 == 3) goto L9;
        if (r110 == 5) goto L9;
        if (r110 == 6) goto L9;
        if (r110 == 7) goto L9;
        String r100 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L10:
        if (r110 == 2) goto L16;
        if (r110 == 3) goto L16;
        if (r110 == 5) goto L16;
        if (r110 == 6) goto L16;
        if (r110 == 7) goto L16;
        int r101 = 3;
    L17:
        Object[] r102 = new Object[r101];
        switch(r110) {
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L21;
            case 6: goto L21;
            case 7: goto L21;
            default: goto L19;
        };
    L19:
        r102[0] = SlcElement.KEY_ELEMENTS;
    L23:
        if (r110 == 2) goto L30;
        if (r110 == 3) goto L30;
        if (r110 == 5) goto L29;
        if (r110 == 6) goto L29;
        if (r110 == 7) goto L29;
        r102[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L31:
        switch(r110) {
            case 2: goto L34;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L34;
            case 6: goto L34;
            case 7: goto L34;
            default: goto L32;
        };
    L32:
        r102[2] = "<init>";
        goto L34
    L33:
        r102[2] = "toArray";
    L34:
        String r103 = String.format(r100, r102);
        if (r110 == 2) goto L42;
        if (r110 == 3) goto L42;
        if (r110 == 5) goto L42;
        if (r110 == 6) goto L42;
        if (r110 == 7) goto L42;
        throw new IllegalArgumentException(r103);
    L42:
        throw new IllegalStateException(r103);
    L29:
        r102[1] = "toArray";
    L30:
        r102[1] = "iterator";
        goto L31
    L20:
        r102[0] = BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY;
        goto L23
    L21:
        r102[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
    L16:
        r101 = 2;
    L9:
        r100 = "@NotNull method %s.%s must not return null";
        goto L10
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int r100 = this.mySize;
        if (r100 != 0) goto L9;
        EmptyIterator r101 = EmptyIterator.getInstance();
        if (r101 != null) goto L7;
        $$$reportNull$$$0(2);
    L7:
        return r101;
    L9:
        if (r100 == 1) goto L11;
        Iterator<E> r102 = super.iterator();
        if (r102 != null) goto L15;
        $$$reportNull$$$0(3);
    L15:
        return r102;
    L11:
        return new SingletonIterator(this);
    }

    public SmartList() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    public static /* synthetic */ int access$100(SmartList r100) {
        return ((AbstractList) r100).modCount;
    }

    public static /* synthetic */ Object access$200(SmartList r100) {
        return r100.myElem;
    }

    public static /* synthetic */ int access$300(SmartList r100) {
        return ((AbstractList) r100).modCount;
    }

    public static /* synthetic */ int access$400(SmartList r100) {
        return ((AbstractList) r100).modCount;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r100) {
        int r101 = this.mySize;
        if (r101 != 0) goto L6;
        this.myElem = r100;
    L15:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    L6:
        if (r101 != 1) goto L8;
        this.myElem = new Object[]{this.myElem, r100};
        goto L15
    L8:
        Object[] r102 = (Object[]) this.myElem;
        int r103 = r102.length;
        if (r101 < r103) goto L14;
        int r104 = ((r103 * 3) / 2) + 1;
        int r105 = r101 + 1;
        if (r104 >= r105) goto L13;
        r104 = r105;
    L13:
        Object[] r106 = new Object[r104];
        this.myElem = r106;
        System.arraycopy(r102, 0, r106, 0, r103);
        r102 = r106;
    L14:
        r102[this.mySize] = r100;
        goto L15
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r100) {
        if (r100 < 0) goto L12;
        int r101 = this.mySize;
        if (r100 >= r101) goto L12;
        if (r101 != 1) goto L10;
        return (E) this.myElem;
    L10:
        return (E) ((Object[]) this.myElem)[r100];
    L12:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r100) {
        if (r100 < 0) goto L19;
        int r101 = this.mySize;
        if (r100 >= r101) goto L19;
        if (r101 != 1) goto L8;
        E r102 = (E) this.myElem;
        this.myElem = null;
    L16:
        this.mySize--;
        ((AbstractList) this).modCount++;
        return r102;
    L8:
        Object[] r103 = (Object[]) this.myElem;
        Object r104 = r103[r100];
        if (r101 != 2) goto L11;
        this.myElem = r103[1 - r100];
    L15:
        r102 = (E) r104;
        goto L16
    L11:
        int r105 = (r101 - r100) - 1;
        if (r105 <= 0) goto L14;
        System.arraycopy(r103, r100 + 1, r103, r100, r105);
    L14:
        r103[this.mySize - 1] = null;
    L19:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + this.mySize);
    }

    @Override // java.util.List
    public void sort(Comparator<? super E> r100) {
        int r101 = this.mySize;
        if (r101 < 2) goto L6;
        Arrays.sort((Object[]) this.myElem, 0, r101, r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r100) {
        if (r100 != 0) goto L4;
        $$$reportNull$$$0(4);
    L4:
        int r101 = r100.length;
        int r102 = this.mySize;
        if (r102 != 1) goto L10;
        if (r101 == 0) goto L8;
        r100[0] = this.myElem;
    L17:
        int r103 = this.mySize;
        if (r101 <= r103) goto L20;
        r100[r103] = 0;
    L20:
        return r100;
    L8:
        T[] r104 = (T[]) ((Object[]) Array.newInstance(r100.getClass().getComponentType(), 1));
        r104[0] = this.myElem;
        return r104;
    L10:
        if (r101 >= r102) goto L15;
        T[] r105 = (T[]) Arrays.copyOf((Object[]) this.myElem, r102, r100.getClass());
        if (r105 != null) goto L14;
        $$$reportNull$$$0(6);
    L14:
        return r105;
    L15:
        if (r102 == 0) goto L17;
        System.arraycopy(this.myElem, 0, r100, 0, r102);
        goto L17
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r100, E r101) {
        if (r100 < 0) goto L20;
        int r102 = this.mySize;
        if (r100 > r102) goto L20;
        if (r102 != 0) goto L9;
        this.myElem = r101;
    L17:
        this.mySize++;
        ((AbstractList) this).modCount++;
        return;
    L9:
        if (r102 != 1) goto L12;
        if (r100 != 0) goto L12;
        this.myElem = new Object[]{r101, this.myElem};
    L12:
        Object[] r103 = new Object[r102 + 1];
        if (r102 != 1) goto L15;
        r103[0] = this.myElem;
    L16:
        r103[r100] = r101;
        this.myElem = r103;
        goto L17
    L15:
        Object[] r104 = (Object[]) this.myElem;
        System.arraycopy(r104, 0, r103, 0, r100);
        System.arraycopy(r104, r100, r103, r100 + 1, this.mySize - r100);
    L20:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r100, E r101) {
        if (r100 < 0) goto L11;
        int r102 = this.mySize;
        if (r100 >= r102) goto L11;
        if (r102 != 1) goto L8;
        E r103 = (E) this.myElem;
        this.myElem = r101;
        return r103;
    L8:
        Object[] r104 = (Object[]) this.myElem;
        E r105 = (E) r104[r100];
        r104[r100] = r101;
        return r105;
    L11:
        throw new IndexOutOfBoundsException("Index: " + r100 + ", Size: " + this.mySize);
    }
}
