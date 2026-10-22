package com.tencent.wcdb.core;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.chaincall.Delete;
import com.tencent.wcdb.chaincall.Insert;
import com.tencent.wcdb.chaincall.Select;
import com.tencent.wcdb.chaincall.Update;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.OrderingTerm;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public class TableORMOperation<T> extends TableOperation {
    TableBinding<T> binding;

    public Delete prepareDelete() throws WCDBException {
        Delete r100 = new Delete(this.database.getHandle(true), false, true);
        r100.fromTable(this.tableName);
        return r100;
    }

    public Insert<T> prepareInsert() {
        Insert<T> r100 = new Insert(this.database.getHandle(true), false, true);
        r100.intoTable(this.tableName);
        return r100;
    }

    public Select<T> prepareSelect() {
        Select<T> r100 = new Select(this.database.getHandle(false), false, true);
        r100.from(this.tableName);
        return r100;
    }

    public Update<T> prepareUpdate() {
        Update<T> r100 = new Update(this.database.getHandle(true), false, true);
        r100.table(this.tableName);
        return r100;
    }

    public TableORMOperation() {
        this.binding = null;
    }

    public void deleteObjects() throws WCDBException {
        prepareDelete().execute();
    }

    public List<T> getAllObjects() throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).allObjects();
    }

    public T getFirstObject() throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).firstObject();
    }

    public TableBinding<T> getBinding() {
        return this.binding;
    }

    public void deleteObjects(Expression r100) throws WCDBException {
        prepareDelete().where(r100).execute();
    }

    public List<T> getAllObjects(Expression r100) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).allObjects();
    }

    public T getFirstObject(Expression r100) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).firstObject();
    }

    public void insertObject(T r100) throws WCDBException {
        prepareInsert().value(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertObjects(Collection<T> r100) throws WCDBException {
        prepareInsert().values(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrIgnoreObject(T r100) throws WCDBException {
        prepareInsert().orIgnore().value(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrIgnoreObjects(Collection<T> r100) throws WCDBException {
        prepareInsert().orIgnore().values(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrReplaceObject(T r100) throws WCDBException {
        prepareInsert().orReplace().value(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void insertOrReplaceObjects(Collection<T> r100) throws WCDBException {
        prepareInsert().orReplace().values(r100).onFields(this.binding.allBindingFields()).execute();
    }

    public void updateObject(T r100) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).execute();
    }

    public List<T> getAllObjects(OrderingTerm r100) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).allObjects();
    }

    public T getFirstObject(OrderingTerm r100) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).firstObject();
    }

    public <R extends T> List<R> getAllObjects(Class<R> r100) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).allObjects(r100);
    }

    public <R extends T> R getFirstObject(Class<R> r100) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).firstObject(r100);
    }

    public List<T> getAllObjects(Field<T>[] r100) throws WCDBException {
        return prepareSelect().select(r100).allObjects();
    }

    public T getFirstObject(Field<T>[] r100) throws WCDBException {
        return prepareSelect().select(r100).firstObject();
    }

    public void deleteObjects(OrderingTerm r100, long r101) throws WCDBException {
        prepareDelete().orderBy(new OrderingTerm[]{r100}).limit(r101).execute();
    }

    public List<T> getAllObjects(Expression r100, OrderingTerm r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).allObjects();
    }

    public T getFirstObject(OrderingTerm r100, long r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(1).offset(r101).firstObject();
    }

    public void insertObject(T r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().value(r100).onFields(r101).execute();
    }

    public void insertObjects(Collection<T> r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().values(r100).onFields(r101).execute();
    }

    public void insertOrIgnoreObject(T r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().orIgnore().value(r100).onFields(r101).execute();
    }

    public void insertOrIgnoreObjects(Collection<T> r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().orIgnore().values(r100).onFields(r101).execute();
    }

    public void insertOrReplaceObject(T r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().orReplace().value(r100).onFields(r101).execute();
    }

    public void insertOrReplaceObjects(Collection<T> r100, Field<T>[] r101) throws WCDBException {
        prepareInsert().orReplace().values(r100).onFields(r101).execute();
    }

    public void updateObject(T r100, Expression r101) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).where(r101).execute();
    }

    public List<T> getAllObjects(OrderingTerm r100, long r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(r101).allObjects();
    }

    public T getFirstObject(Expression r100, OrderingTerm r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).firstObject();
    }

    public void updateObject(T r100, Field<T> r101) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r100, Class<R> r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).allObjects(r101);
    }

    public <R extends T> R getFirstObject(Expression r100, Class<R> r101) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r100).firstObject(r101);
    }

    public void updateObject(T r100, Field<T>[] r101) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r100, Class<R> r101) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).allObjects(r101);
    }

    public <R extends T> R getFirstObject(OrderingTerm r100, Class<R> r101) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).firstObject(r101);
    }

    public List<T> getAllObjects(Field<T>[] r100, Expression r101) throws WCDBException {
        return prepareSelect().select(r100).where(r101).allObjects();
    }

    public T getFirstObject(Field<T>[] r100, Expression r101) throws WCDBException {
        return prepareSelect().select(r100).where(r101).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r100, OrderingTerm r101) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).allObjects();
    }

    public T getFirstObject(Field<T>[] r100, OrderingTerm r101) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).firstObject();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, Class<R> r101) throws WCDBException {
        return prepareSelect().select(r100).allObjects(r101);
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, Class<R> r101) throws WCDBException {
        return (R) prepareSelect().select(r100).firstObject(r101);
    }

    public void deleteObjects(Expression r100, OrderingTerm r101, long r102) throws WCDBException {
        prepareDelete().where(r100).orderBy(new OrderingTerm[]{r101}).limit(r102).execute();
    }

    public List<T> getAllObjects(Expression r100, OrderingTerm r101, long r102) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(r102).allObjects();
    }

    public T getFirstObject(Expression r100, OrderingTerm r101, long r102) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(1).offset(r102).firstObject();
    }

    public void updateObject(T r100, OrderingTerm r101, long r102) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).orderBy(r101).limit(r102).execute();
    }

    public void deleteObjects(OrderingTerm r100, long r101, long r102) throws WCDBException {
        prepareDelete().orderBy(new OrderingTerm[]{r100}).limit(r101).offset(r102).execute();
    }

    public List<T> getAllObjects(OrderingTerm r100, long r101, long r102) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(r101).offset(r102).allObjects();
    }

    public <R extends T> R getFirstObject(OrderingTerm r100, long r101, Class<R> r102) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(1).offset(r101).firstObject(r102);
    }

    public void updateObject(T r100, Field<T> r101, Expression r102) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).where(r102).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r100, OrderingTerm r101, Class<R> r102) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).allObjects(r102);
    }

    public <R extends T> R getFirstObject(Expression r100, OrderingTerm r101, Class<R> r102) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).firstObject(r102);
    }

    public void updateObject(T r100, Field<T>[] r101, Expression r102) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).where(r102).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r100, long r101, Class<R> r102) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(r101).allObjects(r102);
    }

    public T getFirstObject(Field<T>[] r100, OrderingTerm r101, long r102) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).limit(1).offset(r102).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).allObjects();
    }

    public T getFirstObject(Field<T>[] r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).firstObject();
    }

    public List<T> getAllObjects(Field<T>[] r100, OrderingTerm r101, long r102) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).limit(r102).allObjects();
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, Expression r101, Class<R> r102) throws WCDBException {
        return (R) prepareSelect().select(r100).where(r101).firstObject(r102);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, Expression r101, Class<R> r102) throws WCDBException {
        return prepareSelect().select(r100).where(r101).allObjects(r102);
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, OrderingTerm r101, Class<R> r102) throws WCDBException {
        return (R) prepareSelect().select(r100).orderBy(r101).firstObject(r102);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, OrderingTerm r101, Class<R> r102) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).allObjects(r102);
    }

    public void deleteObjects(Expression r100, OrderingTerm r101, long r102, long r103) throws WCDBException {
        prepareDelete().where(r100).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103).execute();
    }

    public List<T> getAllObjects(Expression r100, OrderingTerm r101, long r102, long r103) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(r102).offset(r103).allObjects();
    }

    public <R extends T> R getFirstObject(Expression r100, OrderingTerm r101, long r102, Class<R> r103) throws WCDBException {
        return (R) prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(1).offset(r102).firstObject(r103);
    }

    public void updateObject(T r100, Expression r101, OrderingTerm r102, long r103) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).where(r101).orderBy(r102).limit(r103).execute();
    }

    public <R extends T> List<R> getAllObjects(Expression r100, OrderingTerm r101, long r102, Class<R> r103) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(r102).allObjects(r103);
    }

    public T getFirstObject(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).limit(1).offset(r103).firstObject();
    }

    public void updateObject(T r100, OrderingTerm r101, long r102, long r103) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).orderBy(r101).limit(r102).offset(r103).execute();
    }

    public <R extends T> List<R> getAllObjects(OrderingTerm r100, long r101, long r102, Class<R> r103) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).orderBy(r100).limit(r101).offset(r102).allObjects(r103);
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, OrderingTerm r101, long r102, Class<R> r103) throws WCDBException {
        return (R) prepareSelect().select(r100).orderBy(r101).limit(1).offset(r102).firstObject(r103);
    }

    public void updateObject(T r100, Field<T> r101, OrderingTerm r102, long r103) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).orderBy(r102).limit(r103).execute();
    }

    public List<T> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).limit(r103).allObjects();
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, Expression r101, OrderingTerm r102, Class<R> r103) throws WCDBException {
        return (R) prepareSelect().select(r100).where(r101).orderBy(r102).firstObject(r103);
    }

    public void updateObject(T r100, Field<T>[] r101, OrderingTerm r102, long r103) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).orderBy(r102).limit(r103).execute();
    }

    public List<T> getAllObjects(Field<T>[] r100, OrderingTerm r101, long r102, long r103) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).limit(r102).offset(r103).allObjects();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102, Class<R> r103) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).allObjects(r103);
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, OrderingTerm r101, long r102, Class<R> r103) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).limit(r102).allObjects(r103);
    }

    public <R extends T> List<R> getAllObjects(Expression r100, OrderingTerm r101, long r102, long r103, Class<R> r104) throws WCDBException {
        return prepareSelect().select(this.binding.allBindingFields()).where(r100).orderBy(r101).limit(r102).offset(r103).allObjects(r104);
    }

    public <R extends T> R getFirstObject(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103, Class<R> r104) throws WCDBException {
        return (R) prepareSelect().select(r100).where(r101).orderBy(r102).limit(1).offset(r103).firstObject(r104);
    }

    public void updateObject(T r100, Expression r101, OrderingTerm r102, long r103, long r104) throws WCDBException {
        prepareUpdate().set(this.binding.allBindingFields()).toObject(r100).where(r101).orderBy(r102).limit(r103).offset(r104).execute();
    }

    public List<T> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103, long r104) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).limit(r103).offset(r104).allObjects();
    }

    public void updateObject(T r100, Field<T> r101, Expression r102, OrderingTerm r103, long r104) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).where(r102).orderBy(r103).limit(r104).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103, Class<R> r104) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).limit(r103).allObjects(r104);
    }

    public void updateObject(T r100, Field<T> r101, OrderingTerm r102, long r103, long r104) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).orderBy(r102).limit(r103).offset(r104).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, OrderingTerm r101, long r102, long r103, Class<R> r104) throws WCDBException {
        return prepareSelect().select(r100).orderBy(r101).limit(r102).offset(r103).allObjects(r104);
    }

    public void updateObject(T r100, Field<T>[] r101, Expression r102, OrderingTerm r103, long r104) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).where(r102).orderBy(r103).limit(r104).execute();
    }

    public void updateObject(T r100, Field<T>[] r101, OrderingTerm r102, long r103, long r104) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).orderBy(r102).limit(r103).offset(r104).execute();
    }

    public <R extends T> List<R> getAllObjects(Field<T>[] r100, Expression r101, OrderingTerm r102, long r103, long r104, Class<R> r105) throws WCDBException {
        return prepareSelect().select(r100).where(r101).orderBy(r102).limit(r103).offset(r104).allObjects(r105);
    }

    public void updateObject(T r100, Field<T> r101, Expression r102, OrderingTerm r103, long r104, long r110) throws WCDBException {
        prepareUpdate().set(new Field[]{r101}).toObject(r100).where(r102).orderBy(r103).limit(r104).offset(r110).execute();
    }

    public void updateObject(T r100, Field<T>[] r101, Expression r102, OrderingTerm r103, long r104, long r105) throws WCDBException {
        prepareUpdate().set(r101).toObject(r100).where(r102).orderBy(r103).limit(r104).offset(r105).execute();
    }
}
