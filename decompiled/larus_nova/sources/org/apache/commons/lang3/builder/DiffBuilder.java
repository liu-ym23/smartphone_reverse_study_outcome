package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ArrayUtils;

/* JADX INFO: loaded from: classes42.dex */
public class DiffBuilder {

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$1, reason: invalid class name */
    class AnonymousClass1 extends Diff<Boolean> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ boolean val$lhs;
        final /* synthetic */ boolean val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Boolean getLeft() {
            return Boolean.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Boolean getRight() {
            return Boolean.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass1(DiffBuilder r100, String r101, boolean r102, boolean r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$10, reason: invalid class name */
    class AnonymousClass10 extends Diff<Float[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ float[] val$lhs;
        final /* synthetic */ float[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Float[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Float[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass10(DiffBuilder r100, String r101, float[] r102, float[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$11, reason: invalid class name */
    class AnonymousClass11 extends Diff<Integer> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ int val$lhs;
        final /* synthetic */ int val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Integer getLeft() {
            return Integer.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Integer getRight() {
            return Integer.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass11(DiffBuilder r100, String r101, int r102, int r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$12, reason: invalid class name */
    class AnonymousClass12 extends Diff<Integer[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ int[] val$lhs;
        final /* synthetic */ int[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Integer[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Integer[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass12(DiffBuilder r100, String r101, int[] r102, int[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$13, reason: invalid class name */
    class AnonymousClass13 extends Diff<Long> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ long val$lhs;
        final /* synthetic */ long val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Long getLeft() {
            return Long.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Long getRight() {
            return Long.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass13(DiffBuilder r100, String r101, long r102, long r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$14, reason: invalid class name */
    class AnonymousClass14 extends Diff<Long[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ long[] val$lhs;
        final /* synthetic */ long[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Long[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Long[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass14(DiffBuilder r100, String r101, long[] r102, long[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$15, reason: invalid class name */
    class AnonymousClass15 extends Diff<Short> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ short val$lhs;
        final /* synthetic */ short val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Short getLeft() {
            return Short.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Short getRight() {
            return Short.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass15(DiffBuilder r100, String r101, short r102, short r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$16, reason: invalid class name */
    class AnonymousClass16 extends Diff<Short[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ short[] val$lhs;
        final /* synthetic */ short[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Short[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Short[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass16(DiffBuilder r100, String r101, short[] r102, short[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$17, reason: invalid class name */
    class AnonymousClass17 extends Diff<Object> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ Object val$lhs;
        final /* synthetic */ Object val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object getLeft() {
            return this.val$lhs;
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object getRight() {
            return this.val$rhs;
        }

        public AnonymousClass17(DiffBuilder r100, String r101, Object r102, Object r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$18, reason: invalid class name */
    class AnonymousClass18 extends Diff<Object[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ Object[] val$lhs;
        final /* synthetic */ Object[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object[] getLeft() {
            return this.val$lhs;
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Object[] getRight() {
            return this.val$rhs;
        }

        public AnonymousClass18(DiffBuilder r100, String r101, Object[] r102, Object[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$2, reason: invalid class name */
    class AnonymousClass2 extends Diff<Boolean[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ boolean[] val$lhs;
        final /* synthetic */ boolean[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Boolean[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Boolean[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass2(DiffBuilder r100, String r101, boolean[] r102, boolean[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$3, reason: invalid class name */
    class AnonymousClass3 extends Diff<Byte> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ byte val$lhs;
        final /* synthetic */ byte val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Byte getLeft() {
            return Byte.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Byte getRight() {
            return Byte.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass3(DiffBuilder r100, String r101, byte r102, byte r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$4, reason: invalid class name */
    class AnonymousClass4 extends Diff<Byte[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ byte[] val$lhs;
        final /* synthetic */ byte[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Byte[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Byte[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass4(DiffBuilder r100, String r101, byte[] r102, byte[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$5, reason: invalid class name */
    class AnonymousClass5 extends Diff<Character> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ char val$lhs;
        final /* synthetic */ char val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Character getLeft() {
            return Character.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Character getRight() {
            return Character.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass5(DiffBuilder r100, String r101, char r102, char r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$6, reason: invalid class name */
    class AnonymousClass6 extends Diff<Character[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ char[] val$lhs;
        final /* synthetic */ char[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Character[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Character[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass6(DiffBuilder r100, String r101, char[] r102, char[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$7, reason: invalid class name */
    class AnonymousClass7 extends Diff<Double> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ double val$lhs;
        final /* synthetic */ double val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Double getLeft() {
            return Double.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Double getRight() {
            return Double.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass7(DiffBuilder r100, String r101, double r102, double r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$8, reason: invalid class name */
    class AnonymousClass8 extends Diff<Double[]> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ double[] val$lhs;
        final /* synthetic */ double[] val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Double[] getLeft() {
            return ArrayUtils.toObject(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Double[] getRight() {
            return ArrayUtils.toObject(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass8(DiffBuilder r100, String r101, double[] r102, double[] r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }

    /* JADX INFO: renamed from: org.apache.commons.lang3.builder.DiffBuilder$9, reason: invalid class name */
    class AnonymousClass9 extends Diff<Float> {
        private static final long serialVersionUID = 1;
        final /* synthetic */ DiffBuilder this$0;
        final /* synthetic */ float val$lhs;
        final /* synthetic */ float val$rhs;

        @Override // org.apache.commons.lang3.tuple.Pair
        public Float getLeft() {
            return Float.valueOf(this.val$lhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public Float getRight() {
            return Float.valueOf(this.val$rhs);
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getLeft() {
            return getLeft();
        }

        @Override // org.apache.commons.lang3.tuple.Pair
        public /* bridge */ /* synthetic */ Object getRight() {
            return getRight();
        }

        public AnonymousClass9(DiffBuilder r100, String r101, float r102, float r103) {
            this.val$lhs = r102;
            this.val$rhs = r103;
            super(r101);
        }
    }
}
