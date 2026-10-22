package com.larksuite.component.blockit.entity;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public class TagStruct implements Serializable {
    public boolean hasAdded;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f282989id;
    public String name;
    public List<GrantRecord> owners;
    public int permissionType;
    public boolean subscribed;
    public String teamworkerCount;
    public boolean unavailable;

    public TagStruct() {
    }
}
