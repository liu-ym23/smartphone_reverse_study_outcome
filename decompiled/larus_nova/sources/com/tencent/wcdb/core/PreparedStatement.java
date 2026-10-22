package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.ColumnType;
import com.tencent.wcdb.winq.Statement;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class PreparedStatement extends CppObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean autoFinalize;
    int columnCount;

    /* JADX INFO: renamed from: com.tencent.wcdb.core.PreparedStatement$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$winq$ColumnType = null;

        static {
            int[] r100 = new int[ColumnType.values().length];
            $SwitchMap$com$tencent$wcdb$winq$ColumnType = r100;
            r100[ColumnType.Integer.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Float.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Text.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.BLOB.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Null.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private static native void bindBLOB(long r100, byte[] r101, int r102);

    private static native void bindDouble(long r100, double r101, int r102);

    private static native void bindInteger(long r100, long r101, int r102);

    private static native void bindNull(long r100, int r101);

    private static native int bindParameterIndex(long r100, String r101);

    private static native void bindText(long r100, String r101, int r102);

    private static native boolean checkPrepared(long r100);

    private static native void clearBindings(long r100);

    private static native void finalize(long r100);

    private static native byte[] getBLOB(long r100, int r101);

    private static native int getColumnCount(long r100);

    private static native String getColumnName(long r100, int r101);

    private static native String getColumnTableName(long r100, int r101);

    private static native int getColumnType(long r100, int r101);

    private static native double getDouble(long r100, int r101);

    private static native long getError(long r100);

    private static native long getInteger(long r100, int r101);

    private static native String getOriginalColumnName(long r100, int r101);

    private static native String getText(long r100, int r101);

    private static native boolean isDone(long r100);

    private static native boolean isReadOnly(long r100);

    private static native boolean prepare(long r100, long r101);

    private static native boolean prepareSQL(long r100, String r101);

    private static native void reset(long r100);

    private static native boolean step(long r100);

    private WCDBException createException() {
        return WCDBException.createException(getError(this.cppObj));
    }

    public boolean checkPrepared() {
        return checkPrepared(this.cppObj);
    }

    public void clearBindings() {
        clearBindings(this.cppObj);
    }

    public void finalizeStatement() {
        finalize(this.cppObj);
    }

    public int getColumnCount() {
        if (this.columnCount != (-1)) goto L6;
        this.columnCount = getColumnCount(this.cppObj);
    L6:
        return this.columnCount;
    }

    public List<Value[]> getMultiRows() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(getOneRow());
        step();
        goto L4
    L6:
        return r100;
    }

    public List<Value> getOneColumn() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(getValue(0));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<byte[]> getOneColumnBLOB() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(getBLOB(0));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<Double> getOneColumnDouble() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(Double.valueOf(getDouble(0)));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<Float> getOneColumnFloat() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(Float.valueOf((float) getDouble(0)));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<Integer> getOneColumnInt() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(Integer.valueOf((int) getLong(0)));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<Long> getOneColumnLong() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(Long.valueOf(getLong(0)));
        step();
        goto L4
    L6:
        return r100;
    }

    public List<String> getOneColumnString() throws WCDBException {
        ArrayList r100 = new ArrayList();
        step();
    L4:
        if (isDone(this.cppObj) == true) goto L6;
        r100.add(getText(0));
        step();
        goto L4
    L6:
        return r100;
    }

    public boolean isDone() {
        return isDone(this.cppObj);
    }

    public boolean isReadOnly() {
        return isReadOnly(this.cppObj);
    }

    public void reset() {
        reset(this.cppObj);
    }

    public void step() throws WCDBException {
        if (step(this.cppObj) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public Value[] getOneRow() {
        int r100 = getColumnCount();
        int r101 = 0;
        if (r100 == 0) goto L5;
        Value[] r102 = new Value[r100];
    L7:
        if (r101 >= r100) goto L9;
        r102[r101] = getValue(r101);
        r101 = r101 + 1;
        goto L7
    L9:
        return r102;
    L5:
        return new Value[0];
    }

    static {
    }

    public PreparedStatement(long r100) {
        this.autoFinalize = false;
        this.columnCount = -1;
        this.cppObj = r100;
    }

    public void bindNull(int r100) {
        bindNull(this.cppObj, r100);
    }

    public int bindParameterIndex(String r100) {
        return bindParameterIndex(this.cppObj, r100);
    }

    public void bindRow(Value[] r100) {
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 1;
    L3:
        if (r102 >= r101) goto L5;
        bindValue(r100[r102], r103);
        r103 = r103 + 1;
        r102 = r102 + 1;
        goto L3
    }

    public <T> List<T> getAllObjects(Field<T>[] r100) throws WCDBException {
        return getAllObjects(r100, Field.getBindClass(r100));
    }

    public byte[] getBLOB(int r100) {
        return getBLOB(this.cppObj, r100);
    }

    public boolean getBool(int r100) {
        if (getInteger(this.cppObj, r100) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public byte getByte(int r100) {
        return (byte) getInteger(this.cppObj, r100);
    }

    public String getColumnName(int r100) {
        return getColumnName(this.cppObj, r100);
    }

    public String getColumnTableName(int r100) {
        return getColumnTableName(this.cppObj, r100);
    }

    public ColumnType getColumnType(int r100) {
        return ColumnType.valueOf(getColumnType(this.cppObj, r100));
    }

    public double getDouble(int r100) {
        return getDouble(this.cppObj, r100);
    }

    public float getFloat(int r100) {
        return (float) getDouble(this.cppObj, r100);
    }

    public int getInt(int r100) {
        return (int) getInteger(this.cppObj, r100);
    }

    public long getLong(int r100) {
        return getInteger(this.cppObj, r100);
    }

    public <T> T getOneObject(Field<T>[] r100) {
        return (T) getOneObject(r100, Field.getBindClass(r100));
    }

    public String getOriginalColumnName(int r100) {
        return getOriginalColumnName(this.cppObj, r100);
    }

    public short getShort(int r100) {
        return (short) getInteger(this.cppObj, r100);
    }

    public String getText(int r100) {
        return getText(this.cppObj, r100);
    }

    public Value getValue(int r100) {
        int r101 = getColumnType(this.cppObj, r100);
        if (r101 == 1) goto L19;
        if (r101 == 2) goto L17;
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L13;
        return new Value();
    L13:
        return new Value(getBLOB(this.cppObj, r100));
    L15:
        return new Value(getText(this.cppObj, r100));
    L17:
        return new Value(getDouble(this.cppObj, r100));
    L19:
        return new Value(getInteger(this.cppObj, r100));
    }

    public void prepare(Statement r100) throws WCDBException {
        if (prepare(this.cppObj, CppObject.get(r100)) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void prepare(String r100) throws WCDBException {
        if (prepareSQL(this.cppObj, r100) == false) goto L6;
        return;
    L6:
        throw createException();
    }

    public void bindBLOB(byte[] r100, int r101) {
        if (r100 != null) goto L5;
        bindNull(r101);
        return;
    L5:
        bindBLOB(this.cppObj, r100, r101);
    }

    public void bindBool(Boolean r100, int r101) {
        if (r100 == null) goto L8;
        long r102 = this.cppObj;
        if (r100.booleanValue() == false) goto L6;
        long r103 = 1;
    L7:
        bindInteger(r102, r103, r101);
        return;
    L6:
        r103 = 0;
        goto L7
    L8:
        bindNull(r101);
    }

    public void bindDouble(Float r100, int r101) {
        if (r100 == null) goto L4;
        bindDouble(this.cppObj, r100.floatValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public void bindInteger(Byte r100, int r101) {
        if (r100 == null) goto L4;
        bindInteger(this.cppObj, r100.byteValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public <T> void bindObject(T r100, Field<T>[] r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101.length == 0) goto L11;
        int r102 = 0;
        TableBinding<T> r103 = r101[0].getTableBinding();
        int r104 = r101.length;
        int r105 = 1;
    L7:
        if (r102 >= r104) goto L12;
        r103.bindField(r100, r101[r102], r105, this);
        r105 = r105 + 1;
        r102 = r102 + 1;
        goto L7
    L12:
        return;
    }

    public void bindText(String r100, int r101) {
        if (r100 != null) goto L5;
        bindNull(r101);
        return;
    L5:
        bindText(this.cppObj, r100, r101);
    }

    public void bindValue(Value r100, int r101) {
        if (r100 != null) goto L5;
        bindNull(r101);
        return;
    L5:
        int r102 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$winq$ColumnType[r100.getType().ordinal()];
        if (r102 != 1) goto L8;
        bindInteger(r100.getLong(), r101);
        return;
    L8:
        if (r102 != 2) goto L10;
        bindDouble(r100.getDouble(), r101);
        return;
    L10:
        if (r102 != 3) goto L12;
        bindText(r100.getText(), r101);
        return;
    L12:
        if (r102 != 4) goto L14;
        bindBLOB(r100.getBLOB(), r101);
        return;
    L14:
        if (r102 != 5) goto L26;
        bindNull(r101);
        return;
    }

    public <T, R extends T> List<R> getAllObjects(Field<T>[] r100, Class<R> r101) throws WCDBException {
        TableBinding<T> r102 = r100[0].getTableBinding();
        ArrayList r103 = new ArrayList();
        step();
    L11:
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (isDone(this.cppObj) == true) goto L7;
        r103.add(r102.extractObject(r100, this, r101));     // Catch: ReflectiveOperationException -> L8
        step();     // Catch: ReflectiveOperationException -> L8
        goto L11
    L7:
        return r103;
    }

    public <T, R extends T> R getOneObject(Field<T>[] r100, Class<R> r101) {
        return (R) r100[0].getTableBinding().extractObject(r100, this, r101);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void bindBool(boolean r100, int r101) {
        long r102 = this.cppObj;
        if (r100 == false) goto L5;
        long r103 = 1;
    L6:
        bindInteger(r102, r103, r101);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public void bindDouble(Double r100, int r101) {
        if (r100 == null) goto L4;
        bindDouble(this.cppObj, r100.doubleValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public void bindInteger(Integer r100, int r101) {
        if (r100 == null) goto L4;
        bindInteger(this.cppObj, r100.intValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public <T> void bindObject(T r100, TableBinding<T> r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Field<T>[] r102 = r101.allBindingFields();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 1;
    L5:
        if (r104 >= r103) goto L7;
        r101.bindField(r100, r102[r104], r105, this);
        r105 = r105 + 1;
        r104 = r104 + 1;
        goto L5
    }

    public void bindDouble(float r100, int r101) {
        bindDouble(this.cppObj, r100, r101);
    }

    public void bindInteger(Short r100, int r101) {
        if (r100 == null) goto L4;
        bindInteger(this.cppObj, r100.shortValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public void bindDouble(double r100, int r101) {
        bindDouble(this.cppObj, r100, r101);
    }

    public void bindInteger(Long r100, int r101) {
        if (r100 == null) goto L4;
        bindInteger(this.cppObj, r100.longValue(), r101);
        return;
    L4:
        bindNull(r101);
    }

    public void bindInteger(byte r100, int r101) {
        bindInteger(this.cppObj, r100, r101);
    }

    public void bindInteger(int r100, int r101) {
        bindInteger(this.cppObj, r100, r101);
    }

    public void bindInteger(short r100, int r101) {
        bindInteger(this.cppObj, r100, r101);
    }

    public void bindInteger(long r100, int r101) {
        bindInteger(this.cppObj, r100, r101);
    }

    public <T> void bindObject(T r100, Field<T> r101, int r102) {
        if (r100 != null) goto L5;
        bindNull(r102);
        return;
    L5:
        r101.getTableBinding().bindField(r100, r101, r102, this);
    }
}
