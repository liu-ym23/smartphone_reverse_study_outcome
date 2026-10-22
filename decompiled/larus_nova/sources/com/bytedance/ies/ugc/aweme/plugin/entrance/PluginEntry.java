package com.bytedance.ies.ugc.aweme.plugin.entrance;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes19.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface PluginEntry {
    String[] plugin();

    EntryType type();
}
