package com.larksuite.component.blockit.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes24.dex */
public class CreateTagAndAddItemRequest implements Serializable {
    public BlockInfo blockInfo;
    public String context;
    public int permissionType;
    public int scene;
    public TagInstanceAttr tagAttr;
    public String tagDescription;
    public String tagName;
    public TagSchema tagSchema;
    public int tagType;
    public String uniqId;

    public CreateTagAndAddItemRequest() {
    }
}
