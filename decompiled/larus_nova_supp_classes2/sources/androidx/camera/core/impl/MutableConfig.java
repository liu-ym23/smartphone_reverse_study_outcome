package androidx.camera.core.impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface MutableConfig extends Config {
    <ValueT> void insertOption(Config.Option<ValueT> r1, Config.OptionPriority r2, ValueT r3);

    <ValueT> void insertOption(Config.Option<ValueT> r1, ValueT r2);

    <ValueT> ValueT removeOption(Config.Option<ValueT> r1);
}
