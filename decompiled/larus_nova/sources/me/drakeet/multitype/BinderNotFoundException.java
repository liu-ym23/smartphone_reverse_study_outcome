package me.drakeet.multitype;

/* JADX INFO: loaded from: classes42.dex */
class BinderNotFoundException extends RuntimeException {
    public BinderNotFoundException(Class<?> r100) {
        super("Do you have registered the binder for {className}.class in the adapter/pool?".replace("{className}", r100.getSimpleName()));
    }
}
